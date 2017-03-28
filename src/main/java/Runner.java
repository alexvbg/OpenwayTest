import parser.SimpleCalculator;
import parser.Term;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) throws JAXBException, IOException {
        toResultFile(ExpressionEvaluator.evaluate("sampleTest.xml"));
    }

    private static void toResultFile(List<Double> resultList) throws JAXBException, IOException {

        SimpleCalculator.ExpressionResults expressionResults = new SimpleCalculator.ExpressionResults();

        List<SimpleCalculator.ExpressionResults.ExpressionResult> results = resultList
                .stream()
                .map(Runner::toResult)
                .collect(Collectors.toList());

        expressionResults.setExpressionResult(results);

        SimpleCalculator simpleCalculator = new SimpleCalculator();

        simpleCalculator.setExpressionResults(expressionResults);

        try (OutputStream outputStream = Files.newOutputStream(Paths.get("expressionResult.xml"))) {
            JAXBContext.newInstance(SimpleCalculator.class)
                    .createMarshaller()
                    .marshal(simpleCalculator, outputStream);
        }
    }

    private static SimpleCalculator.ExpressionResults.ExpressionResult toResult(Double value) {
        SimpleCalculator.ExpressionResults.ExpressionResult expressionResult = new SimpleCalculator.ExpressionResults.ExpressionResult();
        expressionResult.setResult(value);
        return expressionResult;
    }

}

class ExpressionEvaluator {

    private ExpressionEvaluator() {
    }

    private static URL getResource(String expressionFilePath) {
        return Thread.currentThread()
                .getContextClassLoader()
                .getResource(expressionFilePath);
    }

    public static List<Double> evaluate(String expressionFilePath) {
        try (InputStream inputStream = Files.newInputStream(Paths.get(getResource(expressionFilePath).toURI()))) {
            return ((SimpleCalculator) JAXBContext.newInstance(SimpleCalculator.class)
                    .createUnmarshaller()
                    .unmarshal(inputStream))
                    .getExpressions()
                    .getExpression()
                    .stream()
                    .map(SimpleCalculator.Expressions.Expression::getOperation)
                    .map(ExpressionEvaluator::visit)
                    .map(Expression::evaluate)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Cannot recognize script: " + e.getMessage());
        }
    }

    private static Expression applyOperation(String operator, Expression leftOperand, Expression rightOperand) {
        switch (operator) {
            case "MUL":
                return Expression.multiplicative(leftOperand, rightOperand);
            case "SUB":
                return Expression.subtraction(leftOperand, rightOperand);
            case "DIV":
                return Expression.division(leftOperand, rightOperand);
            case "SUM":
                return Expression.addition(leftOperand, rightOperand);
            default:
                throw new IllegalArgumentException();
        }
    }

    private static Expression visit(Term term) {

        String operator = term.getOperationType(); // *, -, +, /

        if (term.getOperation().isEmpty()) {

            List<BigInteger> args = term.getArg(); // size is always 2!
            //
            double leftOp = args.get(0).doubleValue();
            double rightOp = args.get(1).doubleValue();
            //
            Expression leftOperand = () -> leftOp;
            Expression rightOperand = () -> rightOp;
            //
            return applyOperation(operator, leftOperand, rightOperand);
        } else {

            List<Term> operations = term.getOperation();

            return applyOperation(operator, visit(operations.get(0)), visit(operations.get(1)));
        }
    }

    private interface Expression {

        Double evaluate();

        ////////////////////////////

        static Expression division(Expression leftOperand, Expression rightOperand) {
            return () -> leftOperand.evaluate() / rightOperand.evaluate();
        }

        static Expression multiplicative(Expression leftOperand, Expression rightOperand) {
            return () -> leftOperand.evaluate() * rightOperand.evaluate();
        }

        static Expression subtraction(Expression leftOperand, Expression rightOperand) {
            return () -> leftOperand.evaluate() - rightOperand.evaluate();
        }

        static Expression addition(Expression leftOperand, Expression rightOperand) {
            return () -> leftOperand.evaluate() + rightOperand.evaluate();
        }
    }
}

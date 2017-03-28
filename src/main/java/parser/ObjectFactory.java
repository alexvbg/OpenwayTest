
package parser;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the parser package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: parser
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SimpleCalculator }
     * 
     */
    public SimpleCalculator createSimpleCalculator() {
        return new SimpleCalculator();
    }

    /**
     * Create an instance of {@link SimpleCalculator.ExpressionResults }
     * 
     */
    public SimpleCalculator.ExpressionResults createSimpleCalculatorExpressionResults() {
        return new SimpleCalculator.ExpressionResults();
    }

    /**
     * Create an instance of {@link SimpleCalculator.Expressions }
     * 
     */
    public SimpleCalculator.Expressions createSimpleCalculatorExpressions() {
        return new SimpleCalculator.Expressions();
    }

    /**
     * Create an instance of {@link Term }
     * 
     */
    public Term createTerm() {
        return new Term();
    }

    /**
     * Create an instance of {@link SimpleCalculator.ExpressionResults.ExpressionResult }
     * 
     */
    public SimpleCalculator.ExpressionResults.ExpressionResult createSimpleCalculatorExpressionResultsExpressionResult() {
        return new SimpleCalculator.ExpressionResults.ExpressionResult();
    }

    /**
     * Create an instance of {@link SimpleCalculator.Expressions.Expression }
     * 
     */
    public SimpleCalculator.Expressions.Expression createSimpleCalculatorExpressionsExpression() {
        return new SimpleCalculator.Expressions.Expression();
    }

}

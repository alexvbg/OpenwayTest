
package parser;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for term complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="term">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="arg" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" maxOccurs="2" minOccurs="2"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *           &lt;element name="operation1" type="{}term"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="operation2" type="{}term"/>
 *           &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="operation" type="{}term" maxOccurs="2" minOccurs="2"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute ref="{}OperationType"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "term", propOrder = {
    "arg",
    "arg1",
    "operation1",
    "operation2",
    "arg2",
    "operation"
})
public class Term {

    @XmlSchemaType(name = "nonNegativeInteger")
    protected List<BigInteger> arg;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger arg1;
    protected Term operation1;
    protected Term operation2;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger arg2;
    protected List<Term> operation;
    @XmlAttribute(name = "OperationType")
    protected String operationType;

    /**
     * Gets the value of the arg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getArg() {
        if (arg == null) {
            arg = new ArrayList<BigInteger>();
        }
        return this.arg;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setArg1(BigInteger value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the operation1 property.
     * 
     * @return
     *     possible object is
     *     {@link Term }
     *     
     */
    public Term getOperation1() {
        return operation1;
    }

    /**
     * Sets the value of the operation1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Term }
     *     
     */
    public void setOperation1(Term value) {
        this.operation1 = value;
    }

    /**
     * Gets the value of the operation2 property.
     * 
     * @return
     *     possible object is
     *     {@link Term }
     *     
     */
    public Term getOperation2() {
        return operation2;
    }

    /**
     * Sets the value of the operation2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Term }
     *     
     */
    public void setOperation2(Term value) {
        this.operation2 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setArg2(BigInteger value) {
        this.arg2 = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Term }
     * 
     * 
     */
    public List<Term> getOperation() {
        if (operation == null) {
            operation = new ArrayList<Term>();
        }
        return this.operation;
    }

    /**
     * Gets the value of the operationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * Sets the value of the operationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationType(String value) {
        this.operationType = value;
    }

}

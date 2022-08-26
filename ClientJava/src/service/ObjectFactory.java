
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
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

    private final static QName _User_QNAME = new QName("http://service/", "user");
    private final static QName _AuthentificationResponse_QNAME = new QName("http://service/", "AuthentificationResponse");
    private final static QName _Authentification_QNAME = new QName("http://service/", "Authentification");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Authentification_Type }
     * 
     */
    public Authentification_Type createAuthentification_Type() {
        return new Authentification_Type();
    }

    /**
     * Create an instance of {@link AuthentificationResponse }
     * 
     */
    public AuthentificationResponse createAuthentificationResponse() {
        return new AuthentificationResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthentificationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "AuthentificationResponse")
    public JAXBElement<AuthentificationResponse> createAuthentificationResponse(AuthentificationResponse value) {
        return new JAXBElement<AuthentificationResponse>(_AuthentificationResponse_QNAME, AuthentificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authentification_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "Authentification")
    public JAXBElement<Authentification_Type> createAuthentification(Authentification_Type value) {
        return new JAXBElement<Authentification_Type>(_Authentification_QNAME, Authentification_Type.class, null, value);
    }

}

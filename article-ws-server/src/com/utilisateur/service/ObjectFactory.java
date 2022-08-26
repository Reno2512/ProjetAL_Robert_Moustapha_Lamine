
package com.utilisateur.service;

import java.sql.SQLException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.utilisateur.service package. 
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

    private final static QName _GetUtilisateurResponse_QNAME = new QName("http://service.utilisateur.com/", "getUtilisateurResponse");
    private final static QName _AddUtilisateur_QNAME = new QName("http://service.utilisateur.com/", "addUtilisateur");
    private final static QName _UpdateUtilisateur_QNAME = new QName("http://service.utilisateur.com/", "updateUtilisateur");
    private final static QName _AddUtilisateurResponse_QNAME = new QName("http://service.utilisateur.com/", "addUtilisateurResponse");
    private final static QName _GetAllUtilisateurs_QNAME = new QName("http://service.utilisateur.com/", "getAllUtilisateurs");
    private final static QName _Authentifier_QNAME = new QName("http://service.utilisateur.com/", "authentifier");
    private final static QName _GetUtilisateur_QNAME = new QName("http://service.utilisateur.com/", "getUtilisateur");
    private final static QName _GetAllUtilisateursResponse_QNAME = new QName("http://service.utilisateur.com/", "getAllUtilisateursResponse");
    private final static QName _SQLException_QNAME = new QName("http://service.utilisateur.com/", "SQLException");
    private final static QName _UpdateUtilisateurResponse_QNAME = new QName("http://service.utilisateur.com/", "updateUtilisateurResponse");
    private final static QName _AuthentifierResponse_QNAME = new QName("http://service.utilisateur.com/", "authentifierResponse");
    private final static QName _DeleteArticle_QNAME = new QName("http://service.utilisateur.com/", "deleteArticle");
    private final static QName _DeleteArticleResponse_QNAME = new QName("http://service.utilisateur.com/", "deleteArticleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.utilisateur.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Authentifier }
     * 
     */
    public Authentifier createAuthentifier() {
        return new Authentifier();
    }

    /**
     * Create an instance of {@link GetUtilisateur }
     * 
     */
    public GetUtilisateur createGetUtilisateur() {
        return new GetUtilisateur();
    }

    /**
     * Create an instance of {@link AddUtilisateurResponse }
     * 
     */
    public AddUtilisateurResponse createAddUtilisateurResponse() {
        return new AddUtilisateurResponse();
    }

    /**
     * Create an instance of {@link GetAllUtilisateurs }
     * 
     */
    public GetAllUtilisateurs createGetAllUtilisateurs() {
        return new GetAllUtilisateurs();
    }

    /**
     * Create an instance of {@link SQLException }
     * 
     */
    public SQLException createSQLException() {
        return new SQLException();
    }

    /**
     * Create an instance of {@link GetAllUtilisateursResponse }
     * 
     */
    public GetAllUtilisateursResponse createGetAllUtilisateursResponse() {
        return new GetAllUtilisateursResponse();
    }

    /**
     * Create an instance of {@link UpdateUtilisateurResponse }
     * 
     */
    public UpdateUtilisateurResponse createUpdateUtilisateurResponse() {
        return new UpdateUtilisateurResponse();
    }

    /**
     * Create an instance of {@link DeleteArticleResponse }
     * 
     */
    public DeleteArticleResponse createDeleteArticleResponse() {
        return new DeleteArticleResponse();
    }

    /**
     * Create an instance of {@link AuthentifierResponse }
     * 
     */
    public AuthentifierResponse createAuthentifierResponse() {
        return new AuthentifierResponse();
    }

    /**
     * Create an instance of {@link DeleteArticle }
     * 
     */
    public DeleteArticle createDeleteArticle() {
        return new DeleteArticle();
    }

    /**
     * Create an instance of {@link GetUtilisateurResponse }
     * 
     */
    public GetUtilisateurResponse createGetUtilisateurResponse() {
        return new GetUtilisateurResponse();
    }

    /**
     * Create an instance of {@link UpdateUtilisateur }
     * 
     */
    public UpdateUtilisateur createUpdateUtilisateur() {
        return new UpdateUtilisateur();
    }

    /**
     * Create an instance of {@link AddUtilisateur }
     * 
     */
    public AddUtilisateur createAddUtilisateur() {
        return new AddUtilisateur();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link SqlException }
     * 
     */
    public SqlException createSqlException() {
        return new SqlException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtilisateurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "getUtilisateurResponse")
    public JAXBElement<GetUtilisateurResponse> createGetUtilisateurResponse(GetUtilisateurResponse value) {
        return new JAXBElement<GetUtilisateurResponse>(_GetUtilisateurResponse_QNAME, GetUtilisateurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUtilisateur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "addUtilisateur")
    public JAXBElement<AddUtilisateur> createAddUtilisateur(AddUtilisateur value) {
        return new JAXBElement<AddUtilisateur>(_AddUtilisateur_QNAME, AddUtilisateur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUtilisateur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "updateUtilisateur")
    public JAXBElement<UpdateUtilisateur> createUpdateUtilisateur(UpdateUtilisateur value) {
        return new JAXBElement<UpdateUtilisateur>(_UpdateUtilisateur_QNAME, UpdateUtilisateur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUtilisateurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "addUtilisateurResponse")
    public JAXBElement<AddUtilisateurResponse> createAddUtilisateurResponse(AddUtilisateurResponse value) {
        return new JAXBElement<AddUtilisateurResponse>(_AddUtilisateurResponse_QNAME, AddUtilisateurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUtilisateurs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "getAllUtilisateurs")
    public JAXBElement<GetAllUtilisateurs> createGetAllUtilisateurs(GetAllUtilisateurs value) {
        return new JAXBElement<GetAllUtilisateurs>(_GetAllUtilisateurs_QNAME, GetAllUtilisateurs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authentifier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "authentifier")
    public JAXBElement<Authentifier> createAuthentifier(Authentifier value) {
        return new JAXBElement<Authentifier>(_Authentifier_QNAME, Authentifier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtilisateur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "getUtilisateur")
    public JAXBElement<GetUtilisateur> createGetUtilisateur(GetUtilisateur value) {
        return new JAXBElement<GetUtilisateur>(_GetUtilisateur_QNAME, GetUtilisateur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUtilisateursResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "getAllUtilisateursResponse")
    public JAXBElement<GetAllUtilisateursResponse> createGetAllUtilisateursResponse(GetAllUtilisateursResponse value) {
        return new JAXBElement<GetAllUtilisateursResponse>(_GetAllUtilisateursResponse_QNAME, GetAllUtilisateursResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SQLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "SQLException")
    public JAXBElement<SQLException> createSQLException(SQLException value) {
        return new JAXBElement<SQLException>(_SQLException_QNAME, SQLException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUtilisateurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "updateUtilisateurResponse")
    public JAXBElement<UpdateUtilisateurResponse> createUpdateUtilisateurResponse(UpdateUtilisateurResponse value) {
        return new JAXBElement<UpdateUtilisateurResponse>(_UpdateUtilisateurResponse_QNAME, UpdateUtilisateurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthentifierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "authentifierResponse")
    public JAXBElement<AuthentifierResponse> createAuthentifierResponse(AuthentifierResponse value) {
        return new JAXBElement<AuthentifierResponse>(_AuthentifierResponse_QNAME, AuthentifierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "deleteArticle")
    public JAXBElement<DeleteArticle> createDeleteArticle(DeleteArticle value) {
        return new JAXBElement<DeleteArticle>(_DeleteArticle_QNAME, DeleteArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.utilisateur.com/", name = "deleteArticleResponse")
    public JAXBElement<DeleteArticleResponse> createDeleteArticleResponse(DeleteArticleResponse value) {
        return new JAXBElement<DeleteArticleResponse>(_DeleteArticleResponse_QNAME, DeleteArticleResponse.class, null, value);
    }

}

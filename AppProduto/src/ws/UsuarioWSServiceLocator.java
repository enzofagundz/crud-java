/**
 * UsuarioWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class UsuarioWSServiceLocator extends org.apache.axis.client.Service implements ws.UsuarioWSService {

    public UsuarioWSServiceLocator() {
    }


    public UsuarioWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UsuarioWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UsuarioWSPort
    private java.lang.String UsuarioWSPort_address = "http://localhost:4568/usuariosws";

    public java.lang.String getUsuarioWSPortAddress() {
        return UsuarioWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UsuarioWSPortWSDDServiceName = "UsuarioWSPort";

    public java.lang.String getUsuarioWSPortWSDDServiceName() {
        return UsuarioWSPortWSDDServiceName;
    }

    public void setUsuarioWSPortWSDDServiceName(java.lang.String name) {
        UsuarioWSPortWSDDServiceName = name;
    }

    public ws.UsuarioWS getUsuarioWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UsuarioWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUsuarioWSPort(endpoint);
    }

    public ws.UsuarioWS getUsuarioWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.UsuarioWSPortBindingStub _stub = new ws.UsuarioWSPortBindingStub(portAddress, this);
            _stub.setPortName(getUsuarioWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUsuarioWSPortEndpointAddress(java.lang.String address) {
        UsuarioWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.UsuarioWS.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.UsuarioWSPortBindingStub _stub = new ws.UsuarioWSPortBindingStub(new java.net.URL(UsuarioWSPort_address), this);
                _stub.setPortName(getUsuarioWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UsuarioWSPort".equals(inputPortName)) {
            return getUsuarioWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws/", "UsuarioWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws/", "UsuarioWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UsuarioWSPort".equals(portName)) {
            setUsuarioWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

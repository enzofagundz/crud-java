/**
 * UsuarioWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public interface UsuarioWS extends java.rmi.Remote {
    public ws.Usuario getUsuarioByLogin(java.lang.String arg0) throws java.rmi.RemoteException;
    public ws.Usuario[] getAllUsuarios() throws java.rmi.RemoteException;
    public void cadastrarUsuario(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException;
    public void removerUsuario(java.lang.String arg0) throws java.rmi.RemoteException;
    public void atualizarUsuario(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException;
}

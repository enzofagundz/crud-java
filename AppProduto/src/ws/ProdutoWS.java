/**
 * ProdutoWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public interface ProdutoWS extends java.rmi.Remote {
    public void cadastrarProduto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public void removerProduto(java.lang.String arg0) throws java.rmi.RemoteException;
    public void atualizarProduto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException;
    public ws.Produto[] getAllProdutos() throws java.rmi.RemoteException;
    public ws.Produto getProdutoById(java.lang.String arg0) throws java.rmi.RemoteException;
}

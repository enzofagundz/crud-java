/**
 * Produto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class Produto  implements java.io.Serializable {
    private java.util.Calendar dataCadastro;

    private java.lang.String descricao;

    private int id;

    private java.lang.String nome;

    private float preco;

    private int quantidade;

    public Produto() {
    }

    public Produto(
           java.util.Calendar dataCadastro,
           java.lang.String descricao,
           int id,
           java.lang.String nome,
           float preco,
           int quantidade) {
           this.dataCadastro = dataCadastro;
           this.descricao = descricao;
           this.id = id;
           this.nome = nome;
           this.preco = preco;
           this.quantidade = quantidade;
    }


    /**
     * Gets the dataCadastro value for this Produto.
     * 
     * @return dataCadastro
     */
    public java.util.Calendar getDataCadastro() {
        return dataCadastro;
    }


    /**
     * Sets the dataCadastro value for this Produto.
     * 
     * @param dataCadastro
     */
    public void setDataCadastro(java.util.Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    /**
     * Gets the descricao value for this Produto.
     * 
     * @return descricao
     */
    public java.lang.String getDescricao() {
        return descricao;
    }


    /**
     * Sets the descricao value for this Produto.
     * 
     * @param descricao
     */
    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }


    /**
     * Gets the id value for this Produto.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Produto.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the nome value for this Produto.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Produto.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the preco value for this Produto.
     * 
     * @return preco
     */
    public float getPreco() {
        return preco;
    }


    /**
     * Sets the preco value for this Produto.
     * 
     * @param preco
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }


    /**
     * Gets the quantidade value for this Produto.
     * 
     * @return quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }


    /**
     * Sets the quantidade value for this Produto.
     * 
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Produto)) return false;
        Produto other = (Produto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataCadastro==null && other.getDataCadastro()==null) || 
             (this.dataCadastro!=null &&
              this.dataCadastro.equals(other.getDataCadastro()))) &&
            ((this.descricao==null && other.getDescricao()==null) || 
             (this.descricao!=null &&
              this.descricao.equals(other.getDescricao()))) &&
            this.id == other.getId() &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            this.preco == other.getPreco() &&
            this.quantidade == other.getQuantidade();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDataCadastro() != null) {
            _hashCode += getDataCadastro().hashCode();
        }
        if (getDescricao() != null) {
            _hashCode += getDescricao().hashCode();
        }
        _hashCode += getId();
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        _hashCode += new Float(getPreco()).hashCode();
        _hashCode += getQuantidade();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Produto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws/", "produto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataCadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataCadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descricao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

package br.marcos.nesbusapi.model.solicitacao;

public class SolicitacaoRetornoDTO {
    private Long compraId;
    private String compraUuid;
    private Float compraValor;
    private Long clienteId;
    private String clienteUuid;
    private String clienteNome;
    private String clienteCpf;
    private String clienteEmail;
    private Long enderecoId;
    private String enderecoCep;
    private String enderecoRua;
    private int enderecoNumero;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoEstado;
    private Long itemCompraId;
    private int itemCompraQuantidade;
    private Float itemCompraValorUnitario;
    private Long produtoId;
    private String produtoUuid;
    private String produtoNome;
    private int produtoQuantidade;
    private Float produtoValor;

    // Getters and Setters

    public Long getCompraId() {
        return compraId;
    }

    public void setCompraId(Long compraId) {
        this.compraId = compraId;
    }

    public String getCompraUuid() {
        return compraUuid;
    }

    public void setCompraUuid(String compraUuid) {
        this.compraUuid = compraUuid;
    }

    public Float getCompraValor() {
        return compraValor;
    }

    public void setCompraValor(Float compraValor) {
        this.compraValor = compraValor;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteUuid() {
        return clienteUuid;
    }

    public void setClienteUuid(String clienteUuid) {
        this.clienteUuid = clienteUuid;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public int getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(int enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoEstado() {
        return enderecoEstado;
    }

    public void setEnderecoEstado(String enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }

    public Long getItemCompraId() {
        return itemCompraId;
    }

    public void setItemCompraId(Long itemCompraId) {
        this.itemCompraId = itemCompraId;
    }

    public int getItemCompraQuantidade() {
        return itemCompraQuantidade;
    }

    public void setItemCompraQuantidade(int itemCompraQuantidade) {
        this.itemCompraQuantidade = itemCompraQuantidade;
    }

    public Float getItemCompraValorUnitario() {
        return itemCompraValorUnitario;
    }

    public void setItemCompraValorUnitario(Float itemCompraValorUnitario) {
        this.itemCompraValorUnitario = itemCompraValorUnitario;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoUuid() {
        return produtoUuid;
    }

    public void setProdutoUuid(String produtoUuid) {
        this.produtoUuid = produtoUuid;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public int getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(int produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }

    public Float getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(Float produtoValor) {
        this.produtoValor = produtoValor;
    }
}


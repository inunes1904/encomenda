package entities;

public class ItemEncomenda {
	private Integer quantidade;
	private double preço;
	private Produto produto;
	
	public ItemEncomenda() {
	
	}

	public ItemEncomenda(int quantidade, double preço, Produto produto) {
		this.quantidade = quantidade;
		this.preço = preço;
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreço() {
		return preço;
	}

	public void setPreço(double preço) {
		this.preço = preço;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public double precosubTotal() {
		return quantidade*preço;
	}
	@Override
	public String toString() {
		return  produto.getNomeProduto()
				+ ", €" 
				+ String.format("%.2f", preço) 
				+ ", Quantidade: " 
				+ quantidade + 
				", Subtotal: €" 
				+ String.format("%.2f", precosubTotal());
	}
}

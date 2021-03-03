package entities;

public class ItemEncomenda {
	private Integer quantidade;
	private double pre�o;
	private Produto produto;
	
	public ItemEncomenda() {
	
	}

	public ItemEncomenda(int quantidade, double pre�o, Produto produto) {
		this.quantidade = quantidade;
		this.pre�o = pre�o;
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPre�o() {
		return pre�o;
	}

	public void setPre�o(double pre�o) {
		this.pre�o = pre�o;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public double precosubTotal() {
		return quantidade*pre�o;
	}
	@Override
	public String toString() {
		return  produto.getNomeProduto()
				+ ", �" 
				+ String.format("%.2f", pre�o) 
				+ ", Quantidade: " 
				+ quantidade + 
				", Subtotal: �" 
				+ String.format("%.2f", precosubTotal());
	}
}

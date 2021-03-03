package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.EstadoEncomenda;

public class Encomenda {
	private static final SimpleDateFormat sdftempo = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	private Date momentoEncomenda;
	private EstadoEncomenda estado;
	
	private Cliente cliente;
	private List<ItemEncomenda> items = new ArrayList<>();
	
	public Encomenda() {
		
	}

	public Encomenda(Date momentoEncomenda, EstadoEncomenda estado, Cliente cliente) {

		this.momentoEncomenda = momentoEncomenda;
		this.estado = estado;
		this.cliente = cliente;
	}

	public Cliente getClient() {
		return cliente;
	}

	public void setClient(Cliente client) {
		this.cliente = client;
	}

	public Date getMomentoEncomenda() {
		return momentoEncomenda;
	}

	public void setMomentoEncomenda(Date momentoEncomenda) {
		this.momentoEncomenda = momentoEncomenda;
	}

	public EstadoEncomenda getEstado() {
		return estado;
	}

	public void setEstado(EstadoEncomenda estado) {
		this.estado = estado;
	}
	
	public List<ItemEncomenda> getItems() {
		return items;
	}
	public void additems(ItemEncomenda item) {
		items.add(item);
	}
	public void removeitems(ItemEncomenda item) {
		items.remove(item);
	}
	public double PrecoTotalEncomenda() {
		double sum=0;
		for( ItemEncomenda c : items) {
			sum+=c.precosubTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento Encomenda: ");
		sb.append(sdftempo.format(momentoEncomenda) + "\n");
		sb.append("Estado Encomenda: ");
		sb.append(estado + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Items encomendados:\n");
		for (ItemEncomenda item : items) {
			sb.append(item + "\n");
		}
		sb.append("Preço Total: €");
		sb.append(String.format("%.2f", PrecoTotalEncomenda()));
		return sb.toString();
	}
	
}

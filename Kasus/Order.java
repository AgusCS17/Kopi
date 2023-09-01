package Kasus;

public class Order {
	private Integer NoOrder;
	private String Coffetype;
	private String Flavor;
	private String Topping;
	private Integer Qty;
	private Integer price;
	private Integer total;
	public Order(Integer noOrder, String coffetype, String flavor, String topping, Integer qty, Integer price,
			Integer total) {
		super();
		NoOrder = noOrder;
		Coffetype = coffetype;
		Flavor = flavor;
		Topping = topping;
		Qty = qty;
		this.price = price;
		this.total = total;
	}
	public Integer getNoOrder() {
		return NoOrder;
	}
	public void setNoOrder(Integer noOrder) {
		NoOrder = noOrder;
	}
	public String getCoffetype() {
		return Coffetype;
	}
	public void setCoffetype(String coffetype) {
		Coffetype = coffetype;
	}
	public String getFlavor() {
		return Flavor;
	}
	public void setFlavor(String flavor) {
		Flavor = flavor;
	}
	public String getTopping() {
		return Topping;
	}
	public void setTopping(String topping) {
		Topping = topping;
	}
	public Integer getQty() {
		return Qty;
	}
	public void setQty(Integer qty) {
		Qty = qty;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
	
	


}

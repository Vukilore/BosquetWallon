package be.ddo.POJO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {
	private int id;
	private String type;
	private int price;
	private int maxSeat;

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getType() { return type; }
	public void setType(CategoryType type) { this.type = type.toString(); }

	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }

	public int getMaxSeat() { return maxSeat; }
	public void setMaxSeat(int maxSeat) { this.maxSeat = maxSeat; }

	public Category(CategoryType type, int price) {
		super();
		this.type = type.toString();
		this.price = price;
		switch(type) {
			case DEBOUT:
				this.maxSeat = 8000;
				break;
			case CONCERT_GOLD :
				this.maxSeat = 500;
				break;
			case CONCERT_SILVER :
				this.maxSeat = 1500;
				break;
			case CONCERT_BRONZE :
				this.maxSeat = 3000;
				break;
			case CIRQUE_DIAMANT:
				this.maxSeat = 1000 ;
				break;
			case CIRQUE_GOLD :
				this.maxSeat = 2000;
				break;
			case CIRQUE_SILVER:
				this.maxSeat = 1500;
				break;
			case CIRQUE_BRONZE:
				this.maxSeat = 1500;
				break;
		}
	}

	public Category(ResultSet result) throws SQLException {
		this.id = result.getInt("IdCategory");
		this.type = result.getString("type");
		this.price = result.getInt("price");
		switch(this.type) {
			case "DEBOUT":
				this.maxSeat = 8000;
				break;
			case "CONCERT_GOLD" :
				this.maxSeat = 500;
				break;
			case "CONCERT_SILVER" :
				this.maxSeat = 1500;
				break;
			case "CONCERT_BRONZE" :
				this.maxSeat = 3000;
				break;
			case "CIRQUE_DIAMANT":
				this.maxSeat = 1000 ;
				break;
			case "CIRQUE_GOLD" :
				this.maxSeat = 2000;
				break;
			case "CIRQUE_SILVER":
				this.maxSeat = 1500;
				break;
			case "CIRQUE_BRONZE":
				this.maxSeat = 1500;
				break;
		}
	}
}

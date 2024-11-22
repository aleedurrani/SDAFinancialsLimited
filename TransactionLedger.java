
public class TransactionLedger {
	private int transaction_id =0;
	private int transaction_acc_id;
	private String transaction_type;
	private String transaction_acc_type;
	private String transaction_date_time;
	private double transaction_amount;
	
	public TransactionLedger() {
		setTransaction_id(-1);
		setTransaction_acc_id(-1);
		setTransaction_type(" ");
		setTransaction_acc_type("");
		setTransaction_date_time("");
		setTransaction_amount(-1);
		
	}
	public TransactionLedger(int i,int t_id,String t_type,String t_acctype,String t_datetime,double t_amount) {
		setTransaction_id(i);
		setTransaction_acc_id(t_id);
		setTransaction_type(t_type);
		setTransaction_acc_type(t_acctype);
		setTransaction_date_time(t_datetime);
		setTransaction_amount(t_amount);
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getTransaction_acc_id() {
		return transaction_acc_id;
	}
	public void setTransaction_acc_id(int transaction_acc_id) {
		this.transaction_acc_id = transaction_acc_id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getTransaction_acc_type() {
		return transaction_acc_type;
	}
	public void setTransaction_acc_type(String transaction_acc_type) {
		this.transaction_acc_type = transaction_acc_type;
	}
	public String getTransaction_date_time() {
		return transaction_date_time;
	}
	public void setTransaction_date_time(String transaction_date_time) {
		this.transaction_date_time = transaction_date_time;
	}
	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	
	

}

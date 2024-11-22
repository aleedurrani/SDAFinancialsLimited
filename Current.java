import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Current extends Account {
	
	private String second_account_holder_name;
	
	Current(String n,String t,int i){
		super.setAcc_holder_name(n);
		setAcc_type(t);
		super.setAcc_id(i);
	}
	Current(String n,String n1,String t,int i){
		super.setAcc_holder_name(n);
		setSecond_account_holder_name(n1);
		setAcc_type(t);
		super.setAcc_id(i);
	}

	public String getAcc_type() {
		
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type=acc_type;
		
	}

	public void deposit(int trans_id,double a, File myfile) {
		acc_balance+=a;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String datetime=dtf.format(now);
		if(acc_balance>=100) {
			dormant=false;
		}
		TransactionLedger new_transaction= new TransactionLedger(trans_id,acc_id,"Deposit",acc_type,datetime,a);
		transaction_list.add(new_transaction);
		System.out.println("Amount Deposited ");
		FileWriter out;
		try {
			out = new FileWriter(myfile,true);
			out.write("Transaction id: "+new_transaction.getTransaction_id()+" | ");
			out.write("Transaction Account id: "+new_transaction.getTransaction_acc_id()+" | ");
			out.write("Transaction Type: "  +new_transaction.getTransaction_acc_type()+" | ");
			out.write("Transaction Amount: "  +new_transaction.getTransaction_amount()+" | ");
			out.write("Transaction Date&Time: "  +new_transaction.getTransaction_date_time()+" | ");
			out.write("Transaction Type: "+new_transaction.getTransaction_type()+"\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean withdrawl(int trans_id,double a,File myfile) {
		boolean flagg=true;
		if(a>acc_balance || dormant==true) {
			System.out.println("Not enough credit OR Account Suspended");
			flagg=false;
		}
		else {
		acc_balance-=a;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String datetime=dtf.format(now);
		if(acc_balance<100) {
			dormant=true;
		}
		TransactionLedger new_transaction= new TransactionLedger(trans_id,acc_id,"Withdrawl",acc_type,datetime,a);
		transaction_list.add(new_transaction);
		System.out.println("Amount withdrawed ");
		FileWriter out;
		try {
			out = new FileWriter(myfile,true);
			out.write("Transaction id: "+new_transaction.getTransaction_id()+" | ");
			out.write("Transaction Account id: "+new_transaction.getTransaction_acc_id()+" | ");
			out.write("Transaction Type: "  +new_transaction.getTransaction_acc_type()+" | ");
			out.write("Transaction Amount: "  +new_transaction.getTransaction_amount()+" | ");
			out.write("Transaction Date&Time: "  +new_transaction.getTransaction_date_time()+" | ");
			out.write("Transaction Type: "+new_transaction.getTransaction_type()+"\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		}
		return flagg;
	}

	public String getSecond_account_holder_name() {
		return second_account_holder_name;
	}

	public void setSecond_account_holder_name(String second_account_holder_name) {
		this.second_account_holder_name = second_account_holder_name;
	}

}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Saving extends Account {
	
	Saving(String n, String t,int i){
		super.setAcc_holder_name(n);
		setAcc_type(t);
		super.setAcc_id(i);
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type=acc_type;
		
	}

	public void deposit(int tran_id,double a, File myfile){
		acc_balance+=a;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String datetime=dtf.format(now);
		if(acc_balance>=100) {
			dormant=false;
		}
		
		TransactionLedger new_transaction= new TransactionLedger(tran_id,acc_id,"Deposit",acc_type,datetime,a);
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
		double penalty=0.0001;
		penalty=penalty*a;
		a=a+penalty;
		
		if(a>acc_balance || dormant==true) {
			System.out.println();
			System.out.println("Not enough credit OR Account suspended ");
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
		
		TransactionLedger new_transaction= new TransactionLedger(trans_id,acc_id,"Withdrwal",acc_type,datetime,a);
		transaction_list.add(new_transaction);
		System.out.println();
		System.out.println("Amount withdrawed");
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

}

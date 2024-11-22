import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Driver {
	public static void main(String[]args) throws IOException{
		ArrayList<User> bank_users= new ArrayList<User>();
		int acc_id=1;
		int transaction_id=1;
		User try_user= new User("Try User","X","Y");
		bank_users.add(try_user);
		
		File myfile= new File("Transactions.txt");
		if(myfile.createNewFile()) {
			System.out.println("File created "+ myfile.getName());
		}
		else { System.out.print("File Already exists");}
		
		System.out.println();
		System.out.println();
		System.out.println("SDA Financials Ltd");
		System.out.println("1.Login");
		System.out.println("2.Signup");
		System.out.println("3.Change Credentials");
		System.out.println("4.Exit");
		
		
		Scanner input = new Scanner(System.in);
		int a= input.nextInt();
		
		
		while(a!=4) {
			
		switch(a) {
		case 1: {
			boolean flag=false;
			System.out.print("ID ");
			String id= input.next();
			System.out.println();
			for(int i=0;i<bank_users.size();i++){
				if(id.equals(bank_users.get(i).getUni_id())) {
					flag=true;
					System.out.print("Password ");
					String password= input.next();
					if(password.equals(bank_users.get(i).getPassword())) {
						System.out.println();
						System.out.println("Login Successful");
						System.out.println();
						System.out.println("What do you want to do");
						System.out.println("1.Open Account");
						System.out.println("2.Close Account");
						System.out.println("3.Withdraw Money");
						System.out.println("4.Deposit Money");
						System.out.println("5.Check Account Status");
						System.out.println("6.Check Balance of an account");
						System.out.println("7.Transactions of a particular Account");
						System.out.println("8.Statement");
						System.out.print("9.Exit to main menu");
						int options= input.nextInt();
						
						while(options!=9) {
						switch(options) {
						case 1:{
							System.out.println();
							System.out.println("Which Type of Account you want to open?");
							System.out.println("1.Saving");
							System.out.println("2.Current");
							int options2=input.nextInt();
							switch(options2) {
							case 1:{
								System.out.println();
								System.out.println("Enter your name");
								String name_input=input.next();
								if(bank_users.get(i).acc_limit()==true) {
								Saving acc= new Saving(name_input,"Saving",acc_id);
								bank_users.get(i).add_account(acc);
								System.out.println();
								System.out.println("Your Saving account has been created and your Account ID is: "+ acc.getAcc_id());
								System.out.println();
								acc_id++;
								}
								else System.out.println("This user already has 3 accounts ");
							}
							break;
							case 2:{
								System.out.println();
								System.out.println("Which one do you want");
								System.out.println("1.Joint Current Account");
								System.out.println("2.Individual Current Account");
								int options3= input.nextInt();
								
								switch(options3) {
								case 1:{
									System.out.println();
									System.out.println("Is the second account owner a registered user?");
									System.out.println("1.Yes");
									System.out.println("2.NO");
									int options4=input.nextInt();
									
									switch(options4) {
									case 1:{
										System.out.println();
										System.out.println("Verifying credentials");
										boolean flag_credentials=false;
										boolean limit=true;
										System.out.print("ID ");
										String ID_joint= input.next();
										for(User tt:bank_users) {
											if(ID_joint.equals(tt.getUni_id())) {
												System.out.print("Password ");
												String pass_joint= input.next();
												if(pass_joint.equals(tt.getPassword())) {
													
													flag_credentials=true;
													if(tt.acc_limit()==false) {
														limit=false;
													}
												}
											}
										}
										if(flag_credentials==true&&limit==true) {
											System.out.println();
											System.out.println("Credentials Verified");
											System.out.println("Enter name of first owner");
											String name1_joint=input.next();
											System.out.println("Enter name of second owner");
											String name2_joint=input.next();
											if(bank_users.get(i).acc_limit()==true) {
											Current curr_acc= new Current(name1_joint,name2_joint,"Current Joint",acc_id);
											bank_users.get(i).add_account(curr_acc);
											System.out.println();
											for(User ttt: bank_users) {
												if(ID_joint.equals(ttt.getUni_id())) {
													ttt.add_account(curr_acc);
												}
											}
											System.out.println("Your joint current account has been created and Account ID is: "+curr_acc.getAcc_id());
											acc_id++;
											}else {
												System.out.println("This user already has 3 accounts ");
											}
											
										}else {
											if(limit==false) {
												System.out.println();
												System.out.println("This user already has 3 accounts, Process returned");
											}
											else if(flag_credentials==false) {
											System.out.println();
											System.out.println("Wrong Credentials, Process returned");
											}
										}
										
									}
									break;
									case 2:{
										System.out.println();
										System.out.println("First register through main menu then try");
									}
									break;
									}
									
									
								}
								break;
								case 2:{
									System.out.println();
									System.out.println("Enter your name");
									String name_input=input.next();
									if(bank_users.get(i).acc_limit()==true) {
									Current acc_indi= new Current(name_input,"-1","Current Individual",acc_id);
									bank_users.get(i).add_account(acc_indi);
									System.out.println();
									System.out.println("Your Current individual account has been created and your Account ID is: "+ acc_indi.getAcc_id());
									System.out.println();	
									acc_id++;
									}else {
										System.out.println("This user already has 3 accounts ");
									}
								}
								break;
								}
							}
							break;
							}
						}
						break;
						case 2:{
							System.out.println();
							System.out.println("Which type of account you want to close");
							System.out.println("1.Individual account");
							System.out.println("2.Joint Account");
							int option5= input.nextInt();
							switch(option5) {
							case 1:{
								System.out.println();
								System.out.println("Enter account id");
								int option6= input.nextInt();
								boolean fgx=false;
								fgx=bank_users.get(i).remove_account(option6);
								if(fgx==true)
								System.out.print("Account closed successfully");
								else System.out.print("Account closure unsuccessful");
							}
							break;
							case 2:{
								System.out.println();
								System.out.println("Enter account id");
								int remove_joint_id= input.nextInt();
								boolean ff=false;
								ff=bank_users.get(i).remove_account(remove_joint_id);
								System.out.print("Enter the ID of second account holder");
								String remove_joint= input.next();
								for(int j=0;j<bank_users.size();j++) {
									if(remove_joint.equals(bank_users.get(j).getUni_id())) {
										ff=bank_users.get(j).remove_account(remove_joint_id);
									}
								}
								if(ff==true) {
								System.out.print("Account closed successfully");
								}else System.out.print("Account closure unsuccessful2");
							}
							break;
							}
							
						}
						break;
						case 3:{
							
							
							System.out.println();
							System.out.println(" From which type of account you want to withdraw money");
							System.out.println("1.Individual account");
							System.out.println("2.Joint Account");
							int option7= input.nextInt();
							switch(option7) {
							case 1:{
								System.out.println();
								System.out.println("Enter account id");
								int option8= input.nextInt();
								System.out.println("Enter amount");
								double option9= input.nextDouble();
								boolean fl=false;
								fl=bank_users.get(i).withdrawl(option8, transaction_id,option9,myfile);
								if(fl==true) {
									transaction_id++;
								}
								else System.out.println("Withdraw Unsucessful");
								
							}
							break;
							case 2:{
								System.out.println();
								System.out.println("Enter account id");
								int withdraw_joint_id= input.nextInt();
								System.out.println("Enter amount");
								double withdraw_amount= input.nextDouble();
								boolean flg=false;
								flg=bank_users.get(i).withdrawl(withdraw_joint_id, transaction_id,withdraw_amount,myfile);
								
								if(flg==true) {
									transaction_id++;
								}
								else System.out.println("Withdraw Unsucessful");
								
								
							}
							break;
							}
							
						}
						break;
						case 4:{
							System.out.println();
							System.out.println(" In which account you want to deposit money");
							System.out.println("1.Individual account");
							System.out.println("2.Joint Account");
							int option7= input.nextInt();
							switch(option7) {
							case 1:{
								System.out.println();
								System.out.println("Enter account id");
								int option8= input.nextInt();
								System.out.println("Enter amount");
								double option9= input.nextDouble();
								boolean fl=false;
								fl=bank_users.get(i).deposit(option8, transaction_id,option9,myfile);
								if(fl==true) {
									transaction_id++;
								}
								else System.out.println("Deposit Unsucessful");
								
							}
							break;
							case 2:{
								System.out.println();
								System.out.println("Enter account id");
								int dep_joint_id= input.nextInt();
								System.out.println("Enter amount");
								double dep_amount= input.nextDouble();
								boolean flg=false;
								flg=bank_users.get(i).deposit(dep_joint_id, transaction_id,dep_amount,myfile);
								
								if(flg==true) {
									transaction_id++;
								}
								else System.out.println("Deposit Unsucessful");
								
								
							}
							break;
							}
						}
						break;
						case 5:{
							System.out.println();
							System.out.println("Enter Account ID: ");
							int id_in=input.nextInt();
							boolean f=false;
							f=bank_users.get(i).account_exists(id_in);
							if(f==true) {
								System.out.print("The account status with the id "+id_in+" is: Dormant="+bank_users.get(i).acc_status(id_in));
								System.out.println();
							}
							else {
								System.out.println();
								System.out.println("You dont have any account with this id");
							}
							
							}
						break;
						case 6:{
							System.out.println();
							System.out.println("Enter Account ID: ");
							int bal_in=input.nextInt();
							boolean f=false;
							f=bank_users.get(i).account_exists(bal_in);
							if(f==true) {
								System.out.print("The account balance with the id "+bal_in+" is:"+bank_users.get(i).acc_balance(bal_in));
								System.out.println();
							}
							else {
								System.out.println();
								System.out.println("You dont have any account with this id");
							}
						}
						break;
						case 7:{
							System.out.println();
							System.out.println("Enter Account ID: ");
							int tra_in=input.nextInt();
							boolean f=false;
							f=bank_users.get(i).account_exists(tra_in);
							if(f==true) {
								
								bank_users.get(i).print_acc_transaction(tra_in);
								System.out.println();
							}
							else {
								System.out.println();
								System.out.println("You dont have any account with this id");
							}
							
						}
						break;
						case 8:{
							System.out.println();
							bank_users.get(i).print_transactions();
								System.out.println();
						}
						break;
						}
						
						
						
						System.out.println();
						System.out.println("What do you want to do");
						System.out.println("1.Open Account");
						System.out.println("2.Close Account");
						System.out.println("3.Withdraw Money");
						System.out.println("4.Deposit Money");
						System.out.println("5.Check Account Status");
						System.out.println("6.Check Balance of an account");
						System.out.println("7.Transactions of a particular Account");
						System.out.println("8.Statement");
						System.out.print("9.Exit to main menu");
						options= input.nextInt();
						
						
						}
					}
					else {
						System.out.print("Incorrect Password, Enter again (one try): ");
						String reenter_password= input.next();
						if(reenter_password.equals(bank_users.get(i).getPassword())) {
							System.out.println();
							System.out.println("Login Successful");
							System.out.println();
						}
						else {
							System.out.println();
							System.out.print("Incorrect password, Login Unsucessful");
							System.out.println();
						}
					}
				}
				
	
			}
			if(flag==false) {
				System.out.println();
				System.out.print("User not registered, First Signup then Login ");
				System.out.println();
			}
			
		}
		break;
		case 2: {
			User new_user= new User();
			System.out.print("ID ");
			String id= input.next();
			new_user.setUni_id(id);
			System.out.println();
			System.out.print("Password ");
			String password= input.next();
			new_user.setPassword(password);
			System.out.println();
			System.out.print("Address ");
			String address= input.next();
			new_user.setAddress(address);
			System.out.println();
			bank_users.add(new_user);
			System.out.print("User registered Succesfully");
			System.out.println();
			System.out.println();
		}
		break;
		case 3:{
			boolean flag_size=false;
			boolean acc_exist=false;
			boolean corr_pass=false;
			if(bank_users.size()>1) {
				flag_size=true;
				System.out.println();
				System.out.println("Enter ID");
				String new_id=input.next();
				for(int i=0;i<bank_users.size();i++) {
					if(bank_users.get(i).getUni_id().equals(new_id)) {
						acc_exist=true;
						System.out.println("Enter existing password");
						String old_pass= input.next();
						if(bank_users.get(i).getPassword().equals(old_pass)) {
							corr_pass=true;
							System.out.println();
							System.out.println("Enter new password");
							String new_pass=input.next();
							bank_users.get(i).setPassword(new_pass);
							System.out.println("Enter new address");
							String new_add=input.next();
							bank_users.get(i).setAddress(new_add);
							System.out.println("Password and address reset succesfull");
						}
					}
				}
				
			}
			if(flag_size==false) {
				System.out.println();
				System.out.println("No user registered, Process returned");
			}
			else if(acc_exist==false) {
				System.out.println();
				System.out.println("This account does not exist, Process returned");
			}
			else if(corr_pass==false) {
				System.out.println();
				System.out.println("Incorrect Password, Process returned");
			}
			
		}
		break;
		default: System.out.println("No option selected");
		}
		
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("Registered Users so far");
		for(User t:bank_users){
			System.out.println("User ID: "+t.getUni_id());
			t.print_accs();
			System.out.println();
		}
		System.out.println("------------------------------------------");
		System.out.println();
		System.out.println("SDA Financials Ltd");
		System.out.println("1.Login");
		System.out.println("2.Signup");
		System.out.println("3.Change Credentials");
		System.out.println("4.Exit");
		
		
		
		a=input.nextInt();		
		
		
		
		
		}
		input.close();
		bank_users=null;
		FileWriter out = new FileWriter(myfile,true);
		out.write("\n____________________________________End______________________________\n");
		out.close();
		
	}

}

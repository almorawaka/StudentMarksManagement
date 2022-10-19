import java.util.*;
class Example{
    public static String [] sIdArr = {"S001","S002","S003"};
    public static String [] sNameArr = {"Asanka","Buddhika","Chamara"};
    public static double [] prfArr = {10.0,50.2,-1};
    public static double [] dbmsArr = {15.5,30.2,-1};
    public static int index;
    
    public static void main(String args[]){
      menu();
    
    }
    
		public static void menu(){
        System.out.println(" ---------------------------------------------------------------");
        System.out.println("|             WELCOME TO MARKS MANAGEMANET SYSTEM      		|");
        System.out.println(" ---------------------------------------------------------------");         
        System.out.println("[1] Add New Student            		[2] Add New Student With Marks \t ");
        System.out.println("[3] Add Marks               		[4] Update Student Details ");
        System.out.println("[5] Update Marks           		[6] Delete Student ");
        System.out.println("[7] Print Student Details        	[8] Print Student Ranks    ");
		System.out.println("[9] Best in PRF               		[10] Best in DBMS ");  
        Scanner input=new Scanner(System.in);
        System.out.print("Enter An Option To Conuntinue : ");
        int x =input.nextInt();
        
        switch(x){
            case 1: addNewStudent(); break;
            case 2: addNewStudentWithMarks(); break;
            case 3: addMarks();break;
            case 4: updateStudentDetails();break;
            case 5: updateMarks(); break;
            case 6: deleteStudent();break;
            case 7: printStudentDetails();break;
            case 8: printStudentRanks(); break;
            case 9: bestPRF();break;
            case 10: bestDBMS();break;
            case 11: printall();break;
            }
        }
		public static void addNewStudent(){    
    char op = 'y';
    while(op=='Y'||op=='y'){
        System.out.println(" ---------------------------------------------------------------");
        System.out.println("|                    ADD NEW STUDENT           				    |");
        System.out.println(" ---------------------------------------------------------------");
        Scanner input = new Scanner(System.in); //System.in is a standard input stream  
  
        boolean duplicate = false;
        while(duplicate ==false){
			        System.out.print("Enter Student Number [Format Sxxx]: ");  
					String sId = input.nextLine();
        for(int i=0; i<sIdArr.length;i++){
            if(sId.equals(sIdArr[i])){
                duplicate = true;
                }
            }
            if(duplicate == true){
            System.out.println("Student ID exist");
            }
                else{
                    addToSidArr(sId);
                    System.out.print("Enter Student Name: ");  
					String sName = input.nextLine();             
					addToNameArr(sName);
                    System.out.print("Student has been added sucessfully, Do you want to add new student([Y]/[N]):");
                    String option=input.nextLine(); 
					op=option.charAt(0);
					break;}
                }
    
        
            
        //~ r =input.nextInt();
            }
        addToPrfArr(-1);
        addToDbmsArr(-1);
        System.out.print("\033[H\033[2J");  
		System.out.flush();  
        menu();
        }
		public static void addNewStudentWithMarks(){    

	
        System.out.println(" ---------------------------------------------------------------");
        System.out.println("|          ADD NEW STUDENT WITH MARKS           		    |");
        System.out.println(" ---------------------------------------------------------------");
        Scanner input = new Scanner(System.in); //System.in is a standard input stream  
        
        boolean duplicate = false;
        while(duplicate ==false){
			System.out.print("Enter Student Number [Format Sxxx]: ");  
			String sId = input.nextLine();  
				for(int i=0; i<sIdArr.length;i++){
					if(sId.equals(sIdArr[i])){
						duplicate = true;
						}
					}
				if(duplicate == true){
				System.out.println("Student ID exist");
				duplicate= false;
				}
                else{
                    addToSidArr(sId);
                    System.out.print("Enter Student Name: ");  
					String sName = input.nextLine();             
					addToNameArr(sName);
					duplicate = true;
                    }
                }
            boolean valid = false;
            double prfMarks;
            System.out.print("Programming Fundamental Marks : ");  
            prfMarks = input.nextDouble();
            while(valid==false){
                if(prfMarks>0 && prfMarks<100){
                    valid=true;
                    }else{
                        System.out.print("Invalid Marks, Please Enter Correct Marks : ");   
                       prfMarks = input.nextDouble();  }
                            }
			addToPrfArr(prfMarks);
        
            valid=false;
            double dbmsMarks;
            System.out.print("Database Management Marks : ");
            dbmsMarks = input.nextDouble();
            while(valid==false){
            if(dbmsMarks>0 &&dbmsMarks<100){
                valid =true;
                }else{
                    System.out.print("Invalid Marks, Please Enter Correct Marks : ");   
                    dbmsMarks = input.nextDouble();  }
                }
			addToDbmsArr(dbmsMarks);
        
  			Scanner user =new Scanner(System.in);
			String op;
			boolean loopBreak = true;			
				do{
					System.out.print("Student has been added sucessfully, Do you want to add new student([Y]/[N]):");
					op = user.nextLine();
				
					if(op.toUpperCase().equals("Y")){
						addNewStudentWithMarks();
						loopBreak = false;
					}else if(op.toUpperCase().equals("N")){
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);


        System.out.print("\033[H\033[2J");  
		System.out.flush();  
        menu();
        }
		public static void addMarks(){ // find student Id and index, add marks to index
		System.out.println(" ---------------------------------------------------------------");
        System.out.println("|             ADD MARKS MARKS 					     		|");
        System.out.println(" ---------------------------------------------------------------"); 
        boolean valid=false;
        while(valid==false){
        System.out.print("Enter Student ID :");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < sIdArr.length; i++) {
			if(sId.equals(sIdArr[i])){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
			
			}
			int op = 1;
			while(op==1){
			if(prfArr[index]==(-1)){
			Scanner input = new Scanner (System.in);
			System.out.println("Enter PRF Marks  :");
			double prfMarks = input.nextDouble();
			addToPrfArr(index,prfMarks);
			System.out.println("Enter DBMS Marks  :");
			double dbmsMarks = input.nextDouble();
			addToDbmsArr(index,dbmsMarks);
			
			Scanner user =new Scanner(System.in);
			String opt;
			boolean loopBreak = true;			
				do{
					System.out.print("Student has been added sucessfully, Do you want to add new student([Y]/[N]):");
					opt = user.nextLine();
					if(opt.toUpperCase().equals("Y")){
						addMarks();
						loopBreak = false;
					}else if(opt.toUpperCase().equals("N")){
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);
			}else{ System.out.println("Plseae use Option 4 to Update data");
					break;}
			}	
			menu();
        }
		public static void updateStudentDetails(){
		System.out.println(" ---------------------------------------------------------------");
        System.out.println("|             UPDATE STUDENT DETAILS			     		|");
        System.out.println(" ---------------------------------------------------------------"); 
		boolean valid=false;
        while(valid==false){
        System.out.println("Enter Student ID");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < sIdArr.length; i++) {
			if(sId.equals(sIdArr[i])){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
			}
			System.out.println("Student ID : "+sIdArr[index]);
			System.out.println("Student Name : "+sNameArr[index]);
			System.out.print("Enter New Student Name : ");
			
			Scanner input = new Scanner(System.in);
			String sName = input.nextLine();
			sNameArr[index] = sName;
		
			Scanner user =new Scanner(System.in);
			String op;
			boolean loopBreak = true;			
				do{
					System.out.print("Student name has been added sucessfully, Do you want to update other name ([Y]/[N]):");
					op = user.nextLine();
				
					if(op.toUpperCase().equals("Y")){
						updateStudentDetails();
						loopBreak = false;
					}else if(op.toUpperCase().equals("N")){
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);
			menu();
		
        }
		public static void updateMarks(){
		System.out.println(" ---------------------------------------------------------------");
        System.out.println("|          		   UPDATE MARKS					     		|");
        System.out.println(" ---------------------------------------------------------------"); 
		boolean valid=false;
        while(valid==false){
        System.out.println("Enter Student ID to Update Marks");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < sIdArr.length; i++) {
			if(sId.equals(sIdArr[i])){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
				if(prfArr[index]==(-1)||dbmsArr[index]==(-1)){
					System.out.println("Student ID yet to be added ");
					updateMarks();}
			}
			System.out.println("Student ID : "+sIdArr[index]);
			System.out.println("Student Name : "+sNameArr[index]);
			System.out.println("PRF Marks : "+prfArr[index]);
			System.out.println("DBMS Marks : "+dbmsArr[index]);
			
			System.out.print("Enter New PRF Marks : ");
			
			Scanner input = new Scanner(System.in);
			double prfMarks = input.nextDouble();
			prfArr[index] = prfMarks;
			System.out.print("Enter New DBMS Marks : ");
			double dbmsMarks = input.nextDouble();
			dbmsArr[index] = dbmsMarks;

			Scanner user =new Scanner(System.in);
			String op;
			boolean loopBreak = true;			
				do{
					System.out.print("Student Marks Updated sucessfully, Do you want to Update Marks for another Student ([Y]/[N]):");
					op = user.nextLine();
				
					if(op.toUpperCase().equals("Y")){
						updateStudentDetails();
						loopBreak = false;
					}else if(op.toUpperCase().equals("N")){
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);
			
			menu();
		}
		public static void deleteStudent(){
		System.out.println(" ---------------------------------------------------------------");
        System.out.println("|           		  DELETE STUDENT		     		|");
        System.out.println(" ---------------------------------------------------------------"); 
		boolean valid=false;
        while(valid==false){
        System.out.print("Enter Student ID	:");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < sIdArr.length; i++) {
			if(sId.equals(sIdArr[i])){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
			}
			System.out.println("Student ID : "+sIdArr[index]);
			System.out.println("Student Name : "+sNameArr[index]);	
			
						Scanner user =new Scanner(System.in);
						String op;
						boolean loopBreak = true;			
							do{
								System.out.print("Are you sure to Detete Student ID"+ sIdArr[index]+ " ? ([Y]/[N]):");
								op = user.nextLine();
							
								if(op.toUpperCase().equals("Y")){								
									op="Y";
									loopBreak = false;
								}else if(op.toUpperCase().equals("N")){
									loopBreak = false;
								}else{
									System.out.print("incorrect .....!\n");
								}
							}while(loopBreak);	
	
			if(op=="Y"){
						for(int i=index; i<sIdArr.length-1; i++){
							sIdArr[i]=sIdArr[i+1];
							sNameArr[i]=sNameArr[i+1];
							prfArr[i]= prfArr[i+1];
							dbmsArr[i]= dbmsArr[i+1];
						}
						String [] temp=new String [sIdArr.length-1];
						String [] temp1 = new String [sNameArr.length-1];
						double [] temp2 = new double [prfArr.length-1];
						double [] temp3 = new double [dbmsArr.length-1];
						for(int i=0; i<temp.length; i++){
							temp[i]=sIdArr[i];
							temp1[i]=sNameArr[i];
							temp2[i]=prfArr[i];
							temp3[i]=dbmsArr[i];
							
						}
						sIdArr=temp;
						sNameArr=temp1;
						prfArr=temp2;
						dbmsArr=temp3;
						System.out.println("Sucessfully Deleted");

						String opt;
						 loopBreak = true;			
							do{
								System.out.print("Do you want to delete more Studetnts ? ([Y]/[N]):");
								opt = user.nextLine();
							
								if(opt.toUpperCase().equals("Y")){
									deleteStudent();
									loopBreak = false;
								}else if(opt.toUpperCase().equals("N")){
									loopBreak = false;
								}else{
									System.out.print("incorrect .....!\n");
								}
							}while(loopBreak);					
					}
				
			menu();
		}		
		public static void printStudentDetails(){
		System.out.println(" ---------------------------------------------------------------");
        System.out.println("|             		PRINT STUDENT DETAILS		     		|");
        System.out.println(" ---------------------------------------------------------------"); 
		boolean valid=false;
        while(valid==false){
        System.out.print("Enter Student ID	:");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < sIdArr.length; i++) {
			if(sId.equals(sIdArr[i])){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
			
			}
			if(prfArr[index]==(-1)){
			System.out.println("Marks yet to be added");
			Scanner user =new Scanner(System.in);
			String input;
			boolean loopBreak = true;
				do{
					System.out.println("Do you want search again : [Y]/[N]");
					input = user.nextLine();
				
					if(input.toUpperCase().equals("Y")){
						printStudentDetails();
						loopBreak = false;
					}else if(input.toUpperCase().equals("N")){
					
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);

		
					}
		
		
		
		System.out.println("Student ID	: "+sIdArr[index] + "	Student Name: "+sNameArr[index]);			
		System.out.println("+------------------------------------------------------+");	
		System.out.printf("| %-45s%-28s\n","SUBJECT","MARKS"+"	|");	
		System.out.println("+------------------------------------------------------+");	
		System.out.printf("| %-45s%-28s\n","Programming Fundamental Marks ",prfArr[index]+"	|");	
		System.out.printf("| %-45s%-28s\n","Database System Management Marks",prfArr[index]+"	|");	
		System.out.printf("| %-45s%-28s\n","Total Marks ",(prfArr[index]+dbmsArr[index])+"	|");	
		System.out.printf("| %-45s%-28s\n","Aveg. Marks",(prfArr[index]+dbmsArr[index])/2+"	|");	
		System.out.printf("| %-45s%-28s\n","Rank Marks"," "+"	|");	
		System.out.println("+----------------------------------------------------------+");		
		
		String input;
		boolean loopBreak = true;
		Scanner user =new Scanner(System.in);
				do{
					System.out.println("Do you want search again : [Y]/[N]");
					
					input = user.nextLine();
				
					if(input.toUpperCase().equals("Y")){
						printStudentDetails();
						loopBreak = false;
					}else if(input.toUpperCase().equals("N")){
					
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);
		
        menu();
	}
		public static void printStudentRanks(){
		System.out.println(" ---------------------------------------------------------------");
        System.out.println("|       	      PRINT STUDENT RANKS    			|");
        System.out.println(" ---------------------------------------------------------------"); 
		//find rank,with relevent sIds
		findRank();
		menu();
		}
        public static void addToNameArr(String sName){
        String [] temp=new String [sNameArr.length+1];
        for (int i = 0; i < sNameArr.length; i++){
            temp[i]=sNameArr[i];
        }
        sNameArr=temp;
        sNameArr[sNameArr.length-1]=sName;
    }
        public static void addToSidArr(String sId){
		String[] temp=new String[sIdArr.length+1];
        for (int i = 0; i < sIdArr.length; i++){
            temp[i]=sIdArr[i];
        }
        sIdArr=temp;
        sIdArr[sIdArr.length-1]=sId;
    }
        public static void addToPrfArr(double prfMarks){
        double[] temp=new double[prfArr.length+1];
        for (int i = 0; i < prfArr.length; i++){
            temp[i]=prfArr[i];
        }
        prfArr=temp;
        prfArr[prfArr.length-1]=prfMarks;
    }
		public static void addToPrfArr(int index, double prfMarks){ //add to the index if not filled
		
				if(index>=0 && index<prfArr.length){
					double [] temp=new double[prfArr.length+1];
						for (int i = 0; i < prfArr.length; i++){
							temp[i]=prfArr[i]; }
							for (int i = temp.length-1; i >index; i--){
								temp[i]=temp[i-1]; }
								temp[index]=prfMarks;
								prfArr=temp;
				}else{ System.out.println("Index error");}
		
   }
        public static void addToDbmsArr(double dbmsMarks){
        double[] temp=new double[dbmsArr.length+1];
        for (int i = 0; i < dbmsArr.length; i++){
            temp[i]=dbmsArr[i];
        }
        dbmsArr=temp;
        dbmsArr[dbmsArr.length-1]=dbmsMarks;
    }
		public static void addToDbmsArr(int index, double dbmsMarks){ //add to the index
	
				if(index>=0 && index<dbmsArr.length){
					double [] temp=new double[dbmsArr.length+1];
					for (int i = 0; i < dbmsArr.length; i++){
						temp[i]=dbmsArr[i];
					}
					for (int i = temp.length-1; i >index; i--){
						temp[i]=temp[i-1]; }
					temp[index]=dbmsMarks;
					dbmsArr=temp;
				}else{ System.out.println("Index error"); }
	
	}	
			
        public static void bestPRF(){
            double max=prfArr[0];
            for(int i=1; i<prfArr.length; i++){
                    if(prfArr[i]>max){
                        max=prfArr[i];
                        index=i;
                    }
                }
        System.out.print("\033[H\033[2J");  
		System.out.flush();  
        System.out.println();
        System.out.println("Best Marks for PRF : "+sNameArr[index]+"\t " + max);
        System.out.println();
        menu();
            }
        public static void bestDBMS(){
            double max=dbmsArr[0];
            for(int i=1; i<dbmsArr.length; i++){
                    if(dbmsArr[i]>max){
                        max=dbmsArr[i];
                        index=i;
                    }
                }
        System.out.print("\033[H\033[2J");  
		System.out.flush();          
        System.out.println();
        System.out.println("Best Marks for DBMS : "+sNameArr[index]+"\t " + max);
        System.out.println();
        menu();
            }    
		public static void findRank(){
			//temp array with totals, sort, index, then rank
			int rank=0;
			double [] temp = new double [sIdArr.length];
			for (int i = 0; i < sIdArr.length; i++) {
				temp[i]=prfArr[i]+ dbmsArr[i];
			}
			String [] sIdTemp = new String[sIdArr.length];
			for (int i = 0; i < sIdArr.length; i++) {
				sIdTemp [i]=sIdArr[i];
			}
			
		for(int i=temp.length-1; i>=0; i--){
            for(int j=0; j<i; j++){ //ar.length-1            
                if(temp[j]>temp[j+1]){
                    double t=temp[j];
                    String s= sIdTemp[j];
                    temp[j]=temp[j+1]; 
                    sIdTemp[j]=sIdTemp[j+1];
                    temp[j+1]=t;
                    sIdTemp[j+1]=s;
                }
             }
        }
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(sIdTemp));
				
			
			}
		public static void printall(){
					System.out.printf("%-15s%-28s%-10s%-10s\n","STUDENT ID","STUDENT NAME","PRF MARKS","DBMS MARKS");
				for (int i = 0; i < sIdArr.length; i++) {
			System.out.printf("%-15s%-25s%10.2f%10.2f\n","|"+sIdArr[i]+"    |","|"+sNameArr[i],prfArr[i],dbmsArr[i]);}
			menu();
}
        
}



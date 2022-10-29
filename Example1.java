import java.util.*;
import java.io.IOException;
class Example1{
    //~ public static String [] sIdArray=	{"S001","S002","S003"}; 				//new String[0]; 
	//~ public static String [] sNameArray=		{"Asanka","Lakmal","Kapila"}; 				// new String[0];
	//~ public static double [] prfMarksArray=	{40.45, -1,67}; 				//new double [0];
	//~ public static double [] dbmsMarksArray=	 {50.6, -1,68}; 			 //new double [0];	
	public static String [] sIdArray= new String[0]; 
	public static String [] sNameArray=	new String[0];
	public static double [] prfMarksArray= new double [0];
	public static double [] dbmsMarksArray=	new double [0];
    public static int index;
    
    public static void main(String args[]){
      menu();
      
    }
   
public static void menu(){
		Scanner input=new Scanner(System.in);	
	
		
        System.out.println(" +-------------------------------------------------------------------+");
        System.out.println(" |             WELCOME TO MARKS MANAGEMANET SYSTEM                   |");
        System.out.println(" +-------------------------------------------------------------------+");  
        System.out.println();       
        System.out.println(" [1] Add New Student            	[2] Add New Student With Marks ");
        System.out.println(" [3] Add Marks               		[4] Update Student Details ");
        System.out.println(" [5] Update Marks           		[6] Delete Student ");
        System.out.println(" [7] Print Student Details        	[8] Print Student Ranks    ");
		System.out.println(" [9] Best in PRF               		[10] Best in DBMS ");  
		System.out.println(" [11] Exit 							");  
        
        System.out.println();
        System.out.print("  Enter An Option To Conuntinue : > ");
      
        String x =input.nextLine();
        validateOption(x);
 

        switch(x){
			case "1": clearConsole(); addNewStudent(); break;
            case "2": clearConsole(); addNewStudentWithMarks(); break;
            case "3": clearConsole(); addMarks();break;
            case "4": clearConsole(); updateStudentDetails();break;
            case "5": clearConsole(); updateMarks(); break;
            case "6": clearConsole(); deleteStudent();break;
            case "7": clearConsole(); printStudentDetails();break;
            case "8": clearConsole(); printStudentRanks(); break;
            case "9": clearConsole(); bestPRF();break;
            case "10": clearConsole(); bestDBMS();break;
            case "11": clearConsole(); System.exit(0);break;
            default:
            System.out.println("Invalid Input!");break;
            }
		} 


	//menu functions

	public static void addNewStudent(){
		boolean addIsComplete=false;
		do{
			Scanner input = new Scanner (System.in);
			System.out.print("Enter Student ID : ");
			String sId = input.nextLine();
			if(validSId(sId)){ //validate sid for input, duplicates etc.
					 System.out.print("Enter Student Name : ");
					 String sName = input.nextLine();
					 if(validName(sName)){
						 extendArray();	//increse array size by one element
						 sIdArray[sIdArray.length-1]=sId;
						 sNameArray[sNameArray.length-1]=sName;
						 prfMarksArray[prfMarksArray.length-1]=-1;	// add -1 to marks
						 dbmsMarksArray[dbmsMarksArray.length-1]=-1;	// add -11 to marks	
						 System.out.print("Student Details Added Sucessfully ! ");
						 addIsComplete = repeatNewStudent(); //add complete if addIsComplete==true else repeat loop
						 }
				 }
			}while(!addIsComplete); // continue loop till addIsComplete == false
			menu();
		}
	public static void addNewStudentWithMarks(){
		boolean addIsComplete=false;
		do{
			Scanner input = new Scanner (System.in);
			System.out.print("Enter Student ID : ");
			String sId = input.nextLine();
			if(validSId(sId)){ //validate sid for input, duplicates etc.
					 System.out.print("Enter Student Name : ");
					 String sName = input.nextLine();
					 if(validName(sName)){
						 extendArray();	//increse array size by one element
						 sIdArray[sIdArray.length-1]=sId;
						 sNameArray[sNameArray.length-1]=sName;
						 addSubjectMarks();		
						 System.out.print("Student Details Added Sucessfully ! ");
						 addIsComplete = repeatWithMarks(); //add complete if addIsComplete==true else repeat loop
						 }
				 }
			}while(!addIsComplete); // continue loop till addIsComplete == false
			menu();
		
		}
	public static void addMarks(){ // find student Id and index, add marks to index
		System.out.println(" +-------------------------------------------------------------+");
        System.out.println(" |                  ADD MARKS MARKS                            |");
        System.out.println(" +-------------------------------------------------------------+"); 
			
			int index = searchSId(); // get index to add marks
			int op = 1;
			while(op==1){
			if(prfMarksArray[index]==(-1)){
				Scanner input = new Scanner (System.in);
				System.out.print("Enter PRF Marks  :");
				double prfMarks = input.nextDouble();
				addPrfMarksToArray(index,prfMarks);
				System.out.print("Enter DBMS Marks  :");
				double dbmsMarks = input.nextDouble();
				addDbmsMarksToArray(index,dbmsMarks);
				repeatAddMarks();
					}else{System.out.println("Plseae use Option 4 to Update data"); break;}
			}	
			menu();
        }
	public static void updateStudentDetails(){
		System.out.println(" ---------------------------------------------------------------");
        System.out.println("|             UPDATE STUDENT DETAILS			     	|");
        System.out.println(" ---------------------------------------------------------------"); 
		boolean valid=false;
        while(valid==false){
        System.out.print("Enter Student ID	:");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < sIdArray.length; i++) {
			if(sId.equals(sIdArray[i])){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
			}
			System.out.println("Student ID : "+sIdArray[index]);
			System.out.println("Student Name : "+sNameArray[index]);
			System.out.print("Enter New Student Name : ");
			
			Scanner input = new Scanner(System.in);
			String sName = input.nextLine();
			sNameArray[index] = sName;
		
			repeatUpdate();
			menu();
		
        }
	public static void updateMarks(){
		System.out.println(" +-------------------------------------------------------------+");
        System.out.println(" |                       UPDATE MARKS                           |");
        System.out.println(" +--------------------------------------------------------------+"); 
		boolean valid=false;
        while(valid==false){
        System.out.print("Enter Student ID to Update Marks	: ");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < sIdArray.length; i++) {
			if(sId.equals(sIdArray[i])){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
				if(prfMarksArray[index]==(-1)||dbmsMarksArray[index]==(-1)){
					System.out.println("Student Marks yet to be added ");
					updateMarks();}
			}
			System.out.println("Student ID : "+sIdArray[index]);
			System.out.println("Student Name : "+sNameArray[index]);
			System.out.println("PRF Marks : "+prfMarksArray[index]);
			System.out.println("DBMS Marks : "+dbmsMarksArray[index]);
			
			System.out.print("Enter New PRF Marks : ");
			
			Scanner input = new Scanner(System.in);
			double prfMarks = input.nextDouble();
			prfMarksArray[index] = prfMarks;
			System.out.print("Enter New DBMS Marks : ");
			double dbmsMarks = input.nextDouble();
			dbmsMarksArray[index] = dbmsMarks;
			repeatUpdateMarks();
			menu();
		}
	public static void deleteStudent(){
		System.out.println(" +-------------------------------------------------------------+");
        System.out.println(" |           		  DELETE STUDENT		       |");
        System.out.println(" +-------------------------------------------------------------+"); 
		boolean valid=false;
        while(valid==false){
        System.out.print("Enter Student ID	:");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < sIdArray.length; i++) {
			if(sId.equals(sIdArray[i])){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
			}
			System.out.println("Student ID : "+sIdArray[index]);
			System.out.println("Student Name : "+sNameArray[index]);	
			
			String op = conformToDelete();			
			if(op=="Y"){
						for(int i=index; i<sIdArray.length-1; i++){
							sIdArray[i]=sIdArray[i+1];
							sNameArray[i]=sNameArray[i+1];
							prfMarksArray[i]= prfMarksArray[i+1];
							dbmsMarksArray[i]= dbmsMarksArray[i+1];
						}
						String [] temp=new String [sIdArray.length-1];
						String [] temp1 = new String [sNameArray.length-1];
						double [] temp2 = new double [prfMarksArray.length-1];
						double [] temp3 = new double [dbmsMarksArray.length-1];
						for(int i=0; i<temp.length; i++){
							temp[i]=sIdArray[i];
							temp1[i]=sNameArray[i];
							temp2[i]=prfMarksArray[i];
							temp3[i]=dbmsMarksArray[i];
							
						}
						sIdArray=temp;
						sNameArray=temp1;
						prfMarksArray=temp2;
						dbmsMarksArray=temp3;
						System.out.println("Sucessfully Deleted");
						repeatDelete();
						
					}
			clearConsole();
			menu();
		}		
	public static void printStudentDetails(){
		int r=0;
		System.out.println(" +-------------------------------------------------------------+");
        System.out.println(" |             		PRINT STUDENT DETAILS		       |");
        System.out.println(" +-------------------------------------------------------------+"); 
		boolean valid=false;
        while(valid==false){
			System.out.print("  Enter Student ID	:");
			Scanner input = new Scanner (System.in);
			String sId = input.nextLine();
			r =getRank(sId);

			for (int i = 0; i < sIdArray.length; i++) {
				if(sId.equals(sIdArray[i])){
					index=i ;
					valid=true;}
				}
			if(valid == false){
					System.out.print(" Student ID not Valid, please ");}
				}
			
			if(prfMarksArray[index]==(-1)){
			System.out.println("  Marks yet to be added");
			repeatPrintStudentDetails();
			}
			
		System.out.println(" Student ID	: "+sIdArray[index] + "	Student Name: "+sNameArray[index]);			
		System.out.println(" +------------------------------------------------------+");	
		System.out.printf(" | %-45s%-28s\n","SUBJECT","MARKS"+"	|  ");	
		System.out.println(" +------------------------------------------------------+");	
		System.out.printf(" | %-45s%-28s\n","Programming Fundamental Marks ",prfMarksArray[index]+"	|");	
		System.out.printf(" | %-45s%-28s\n","Database System Management Marks",dbmsMarksArray[index]+"	|");	
		System.out.printf(" | %-45s%-28s\n","Total Marks ",(prfMarksArray[index]+dbmsMarksArray[index])+"	|");	
		System.out.printf(" | %-45s%-28s\n","Aveg. Marks",(prfMarksArray[index]+dbmsMarksArray[index])/2+"	|");
		System.out.printf(" | %-45s%-28s\n","Rank ", r+"	|");	
		System.out.println(" +-------------------------------------------------------+");		
		repeatPrintStudentDetails();
        menu();
}
	public static void printStudentRanks(){
		System.out.println(" ---------------------------------------------------------------");
        System.out.println("|       	      PRINT STUDENT RANKS    			|");
        System.out.println(" ---------------------------------------------------------------"); 
		findRank();
		menu();
		}
	public static void bestPRF(){
            double max=prfMarksArray[0];
            for(int i=1; i<prfMarksArray.length; i++){
                    if(prfMarksArray[i]>max){
                        max=prfMarksArray[i];
                        index=i;
                    }
                }
        clearConsole();
        System.out.println("Best Marks for PRF : "+sNameArray[index]+"\t " + max);
        System.out.println();
        findPrfRank();
        menu();
            }
    public static void bestDBMS(){
            double max=dbmsMarksArray[0];
            for(int i=1; i<dbmsMarksArray.length; i++){
                    if(dbmsMarksArray[i]>max){
                        max=dbmsMarksArray[i];
                        index=i;
                    }
                }
		clearConsole();
        System.out.println("Best Marks for DBMS : "+sNameArray[index]+"\t " + max);
        System.out.println();
        findDbmsRank();
        menu();
            }  
	
	// input data validation 
	
	public static void clearConsole(){
		try {
				if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					} else {
						System.out.print("\033\143"); }
						} catch (IOException | InterruptedException ex) {}
		}
	public static boolean validSId(String sId){
		boolean valid=false;
		String S="S", s="s";
			if(sId == null || sId.equals("")){
				System.out.println("Input Error");
				addNewStudent(); }
			else if(!sId.matches("[a-zA-Z0-9]*")){
				System.out.println("Input Error");
				addNewStudent();}
			else if(duplicateCheck(sId)){
				System.out.println("Student ID can't duplicate ! ");
				addNewStudent();}	
			else if(sId.substring(0,1).equals(S)||sId.substring(0,1).equals(s)){
				valid = true; }
				
			return valid;
		}
	public static boolean validName(String sName){
			if(sName == null || sName.equals("")){
				return false;}
			if(sName.matches("[a-zA-Z]*")){
				return true;}
			else{
				return false;}
			}
	public static void validateOption(String x){		         
		try { 
			Integer.parseInt(x); }  
		catch (NumberFormatException e) {
			clearConsole(); //give error message on clear screen
			System.out.println(); 
			System.out.println(x+ " is not a valid integer"); 
			System.out.println(); 
			menu();
		} 
}


	// function to get conformation to proceed
	
	public static boolean repeatNewStudent(){
			boolean repeat =false;
			Scanner input = new Scanner(System.in);
				do { 
					System.out.print("Do you want to repeat above process [Y]/[N]?");
					String op = input.nextLine();
					if(op.toUpperCase().equals("Y")){
					return repeat;} // stop this do-while loop and return false to continue repeating addNewStudent() Mtd.
						else if (op.toUpperCase().equals("N")){
						repeat = true;}
							else{
							System.out.println("Wrong Entry...!");
							repeat = false; // repeat this loop till correct entry recived.
							}
						}while(repeat==false); 			
			return repeat; // return true to discountinue repeating addNewStudent Mtd. 
		}
	public static boolean repeatWithMarks(){
			boolean repeat =true;
			Scanner input = new Scanner(System.in);
			while(repeat==true){ 
			 System.out.print("Do you want to add more student with marks [Y]/[N]?");
				String op = input.nextLine();
					if(op.toUpperCase().equals("Y")){
					addNewStudentWithMarks();
					repeat=false;}
						else if (op.toUpperCase().equals("N")){
						clearConsole();
						menu();
						repeat = false;}
							else{
							System.out.println("Wrong Entry...!");
							repeat = true;
							}
						}			
			return repeat;
		}	
	public static void repeatAddMarks(){
		Scanner input =new Scanner(System.in);
			boolean loopBreak = true;			
				do{
					System.out.print("Marks added sucessfully, Do you want add more Marks([Y]/[N]):");
					String opt = input.nextLine();
					if(opt.toUpperCase().equals("Y")){
						addMarks();
						loopBreak = false;
					}else if(opt.toUpperCase().equals("N")){
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);
		}
	public static void repeatUpdate(){
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
				}while(loopBreak);}
	public static void repeatUpdateMarks(){
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
				}while(loopBreak);}
	public static void repeatDelete(){
			String opt;
			boolean loopBreak = true;
			Scanner user = new Scanner(System.in);			
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
	public static String conformToDelete(){
		Scanner user =new Scanner(System.in);
						String op;
						boolean loopBreak = true;			
							do{
								System.out.print("Are you sure to Detete Student ID "+ sIdArray[index]+ " and all relevent Data? ([Y]/[N]):");
								op = user.nextLine();
							
								if(op.toUpperCase().equals("Y")){								
									op="Y";
									loopBreak = false;
								}else if(op.toUpperCase().equals("N")){
									op="N";
									loopBreak = false;
								}else{
									System.out.print("incorrect .....!\n");
								}
							}while(loopBreak);	
					return op;}
	public static void repeatPrintStudentDetails(){
		Scanner user =new Scanner(System.in);
			String input;
			boolean loopBreak = true;
				do{
					System.out.println("  Do you want search again : [Y]/[N]");
					input = user.nextLine();
					if(input.toUpperCase().equals("Y")){
						printStudentDetails();
						loopBreak = false;
					}else if(input.toUpperCase().equals("N")){
					
						loopBreak = false;
					}else{
						System.out.print(" incorrect .....!\n");
					}
				}while(loopBreak);
			}

	// other methods
	
	public static void addSubjectMarks(){
					boolean addPrfMarks=true; 
					boolean addDbmsMarks=true;
					Scanner input =new Scanner (System.in);
						 
						 do{ if(addPrfMarks){	
								 System.out.print("Enter PRF Marks : ");						 
								 double	prfMarks = input.nextDouble();
								 if(!marksValid(prfMarks)){
								 prfMarksArray[prfMarksArray.length-1]=prfMarks;
								 addPrfMarks=true;
									}else{addPrfMarks=false;}	
								}
							 if(addDbmsMarks){	
								 System.out.print("Enter DBMS Marks : ");							 				 
								 double	dbmsMarks = input.nextDouble();
								 if(!marksValid(dbmsMarks)){
								 dbmsMarksArray[dbmsMarksArray.length-1]=dbmsMarks;	
								 addDbmsMarks=true;
									}else{addDbmsMarks=false;}
								}
								
							}while(!addPrfMarks ^ !addDbmsMarks);
				}	
	public static int getRank(String sId){ // soart arrays according to prf marks		
					//temp array with totals, sort, index, then rank
			int rank=0;
			double [] temp = new double [sIdArray.length];
			for (int i = 0; i < sIdArray.length; i++) {
				temp[i]=prfMarksArray[i]+ dbmsMarksArray[i];
				}
			String [] sIdTemp = new String[sIdArray.length];
			for (int i = 0; i < sIdArray.length; i++) {
				sIdTemp [i]=sIdArray[i];
				}
			
			for(int i=temp.length-1; i>=0; i--){  //bubble sort
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
        int [] rankArr  = new int [sIdTemp.length];
        for (int i = 0; i < sIdTemp.length; i++) {
			rankArr[i] = sIdTemp.length-1-i;
			}
			for (int i = 0; i < sIdTemp.length; i++) {
				if(sId.equals(sIdArray[i])){
					rank = rankArr[i]; }
					}
			return rank;
		}   
	public static void findRank(){
			//temp array with totals, sort, index, then rank
			int rank=0;
			double [] temp = new double [sIdArray.length];
			for (int i = 0; i < sIdArray.length; i++) {
				temp[i]=prfMarksArray[i]+ dbmsMarksArray[i];
			}
			String [] sIdTemp = new String[sIdArray.length];
			for (int i = 0; i < sIdArray.length; i++) {
				sIdTemp [i]=sIdArray[i];
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
        int [] rankArr  = new int [sIdTemp.length];
        for (int i = 0; i < sIdTemp.length; i++) {
			rankArr[i] = (sIdTemp.length-1-i);
		}
		System.out.println("+----------------------------------------------+");	
		System.out.printf("| %-15s%-15s%-18s\n","RANK","SUBJECT","TOTAL MARKS"+"    |");	
		System.out.println("+----------------------------------------------+");
	
			for (int i = 0; i < sIdTemp.length; i++) {
				System.out.printf("| %-15s%-15s%-18s\n" ,rankArr[i]+1,sIdTemp[i],temp[i]+"           |");
					}
		System.out.println("+----------------------------------------------+");
		System.out.println();
		System.out.println();
		System.out.println();
		}
	public static void findPrfRank(){ // soart arrays according to prf marks		
	
        for(int i=0; i<prfMarksArray.length-1; i++){
            for(int j=0; j<prfMarksArray.length-1; j++){ //ar.length-1            
                if(prfMarksArray[j]<prfMarksArray[j+1]){
                    double t=prfMarksArray[j];
                    double temp = dbmsMarksArray[j];
                    String s=sIdArray[j];
                    String name = sNameArray[j];
                    prfMarksArray[j]=prfMarksArray[j+1]; 
                    dbmsMarksArray[j]=dbmsMarksArray[j+1]; 
                    sIdArray[j]=sIdArray[j+1];
                    sNameArray[j]=sNameArray[j+1];
                    prfMarksArray[j+1]=t;
                    dbmsMarksArray[j+1]=temp;
                    sIdArray[j+1]=s;
                    sNameArray[j+1]=name;
                }
            }
        }
   

        System.out.println("+-----------------------------------------------------------------+");	
		System.out.printf( "| %-15s%-15s%-18s%-15s\n","SID","NAME","PRF MARKS","DBMS MARKS"+"      |");	
		System.out.println("+-----------------------------------------------------------------+");
	
			for (int i = 0; i < sIdArray.length; i++) {
				System.out.printf("| %-15s%-15s%-18s%-18s\n" ,sIdArray[i],sNameArray[i],prfMarksArray[i],dbmsMarksArray[i]+"            |");
					}
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println();

		}  
	public static void findDbmsRank(){ // soart arrays according to prf marks		
	
        for(int i=0; i<dbmsMarksArray.length-1; i++){
            for(int j=0; j<dbmsMarksArray.length-1; j++){ //ar.length-1            
                if(dbmsMarksArray[j]<dbmsMarksArray[j+1]){
                    double t=prfMarksArray[j];
                    double temp = dbmsMarksArray[j];
                    String s=sIdArray[j];
                    String name = sNameArray[j];
                    prfMarksArray[j]=prfMarksArray[j+1]; 
                    dbmsMarksArray[j]=dbmsMarksArray[j+1]; 
                    sIdArray[j]=sIdArray[j+1];
                    sNameArray[j]=sNameArray[j+1];
                    prfMarksArray[j+1]=t;
                    dbmsMarksArray[j+1]=temp;
                    sIdArray[j+1]=s;
                    sNameArray[j+1]=name;
                }
            }
        }
   

        System.out.println("+-----------------------------------------------------------------+");	
		System.out.printf( "| %-15s%-15s%-18s%-15s\n","SID","NAME","PRF MARKS","DBMS MARKS"+"      |");	
		System.out.println("+-----------------------------------------------------------------+");
	
			for (int i = 0; i < sIdArray.length; i++) {
				System.out.printf("| %-15s%-15s%-18s%-18s\n" ,sIdArray[i],sNameArray[i],prfMarksArray[i],dbmsMarksArray[i]+"            |");
					}
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println();

		}    	
	public static int searchSId(){
		boolean valid=false;
		int index=0;
        while(!valid){
			System.out.print("Enter Student ID :");
			Scanner input = new Scanner (System.in);
			String sId = input.nextLine();
			for (int i = 0; i < sIdArray.length; i++) {
				if(sId.equals(sIdArray[i])){
					index=i ;
					valid=true;}
				}
				if(!valid){
					System.out.print(" "+sId +"  Student ID not Available, please ");}
			}
			return index; 
		}	
	public static void addPrfMarksToArray(int index, double prfMarks){
					if(index>=0 && index<prfMarksArray.length){
					double [] temp=new double[prfMarksArray.length+1];
						for (int i = 0; i < prfMarksArray.length; i++){
							temp[i]=prfMarksArray[i]; }
							for (int i = temp.length-1; i >index; i--){
								temp[i]=temp[i-1]; }
								temp[index]=prfMarks;
								prfMarksArray=temp;
				}else{ System.out.println("Index error");
						}
		}	
	public static void addDbmsMarksToArray(int index,double dbmsMarks){
					if(index>=0 && index<dbmsMarksArray.length){
					double [] temp=new double[dbmsMarksArray.length+1];
					for (int i = 0; i < dbmsMarksArray.length; i++){
						temp[i]=dbmsMarksArray[i];
					}
					for (int i = temp.length-1; i >index; i--){
						temp[i]=temp[i-1]; }
					temp[index]=dbmsMarks;
					dbmsMarksArray=temp;
				}else{ System.out.println("Index error"); }
		}	
	public static boolean marksValid(double marks){
		boolean valid = false;
			if (marks>100 || marks<0){
				System.out.print("Marks not valid ");
				valid=false; 
				return valid;}
				else {valid = true; }
			return valid;
		}	
	public static void extendArray(){
		int size=(sIdArray.length+1);
		String[] temp0=new String[size];
		String[] temp1=new String[size];
		double[] temp2=new double[size];
		double[] temp3=new double[size];
		
		for (int i = 0; i < size-1; i++){
			temp0[i]=sIdArray[i];
			temp1[i]=sNameArray[i];
			temp2[i]=prfMarksArray[i];
			temp3[i]=dbmsMarksArray[i];
			}
		sIdArray=temp0;
		sNameArray=temp1;
		prfMarksArray=temp2;
		dbmsMarksArray=temp3;
		//System.out.println(Arrays.toString(sIdArray));
	
		}
	public static boolean duplicateCheck(String sId){
			boolean duplicate =false;
			for(int i=0; i<sIdArray.length;i++){	//check for duplicate SID,
				if(sId.equals(sIdArray[i])){
					duplicate = true;}	
						}
			//System.out.println("Diplicate method");						
			return (duplicate);
         }

}
   
 

import java.sql.*;
import java.io.*;

import java.util.Scanner;
public class ejercicio5 {

	public static void main (String[] args){
	try{	
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";



		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username, password);
		int opcion;
		boolean salir=true;
		Scanner sc = new Scanner(System.in);
		while(salir){
			System.out.println("QUE DESEA HACER?? \n 1- INSERTAR UN DONANTE. \n 2- ELIMINAR UN DONANTE \n 3-LISTAR DONANTES \n 4- salir");
			opcion=sc.nextInt();
			if(opcion==1){insertarDonante(connection);}
			if(opcion==2){eliminarDonante(connection);}
			if(opcion==3){listarDonantes(connection);}
			if(opcion==4){salir=false;}
			

		}
			






		 } catch(ClassNotFoundException cnfe) {
	      System.err.println("Error loading driver: " + cnfe);
	     } catch(SQLException sqle) {
	    	sqle.printStackTrace();
	      System.err.println("Error connecting: " + sqle);
	      }

	}


	public static void insertarDonante(Connection connection){
	
	try{
		//datos para insertar en persona
		String dni=cargarPersona(connection);
		cargarPadrino(dni, connection);
	    cargarDonante(dni,connection);
		int id = cargarMedioPago(connection);
		String nombre_programa = cargarPrograma(connection);
		cargarAporta(dni,nombre_programa,id,connection);
		
		




	} catch(SQLException sqle) {
    	sqle.printStackTrace();
      System.err.println("Error connecting: " + sqle);
    };






	}


	public static String cargarPersona(Connection connection) throws SQLException{
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("INGRESE EL DNI DE LA DONANTE");

			String dni=sc.nextLine();

			String query = "select (dni) from ciudad_de_los_niños.persona where (dni='"+dni+"') ";

	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(query);
	    	if (!(resultSet.next())){
	    		System.out.println("La persona no esta cargada en la base de datos!");
	    		System.out.println("Ingrese el nombre y apellido");

				String nombreAp=sc.nextLine();

				 query = "insert into ciudad_de_los_niños.persona (dni,n_y_ap) values(?,?)";

	    		PreparedStatement statement1 = connection.prepareStatement(query);
	     
	     		statement1.setString(1,dni);
	     		statement1.setString(2,nombreAp);
	     		statement1.executeUpdate();
	     	 	return dni;
	     	 };
	     	 return dni;
		
		}catch(SQLException sqle) {
    		sqle.printStackTrace();
      		System.err.println("Error connecting: " + sqle);
    	 	throw sqle;
    	 }
	

	}

    public static void cargarPadrino(String dni,Connection connection)throws SQLException{
		try{
			Scanner sc = new Scanner(System.in);
			

			String query = "select (dni) from ciudad_de_los_niños.padrino where (dni='"+dni+"') ";

	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(query);
	    	if (!(resultSet.next())){
				System.out.println("el padrino no esta cargado en la base de datos!");
	    		System.out.println("Ingrese el email");
	    		String email=sc.nextLine();
				System.out.println("Ingrese el telefono fijo");
			    String tel_fijo=sc.nextLine();
  				System.out.println("Ingrese el la direccion");
		     	String direccion=sc.nextLine();
			    System.out.println("Ingrese el celular");
		      	String celular=sc.nextLine();
			    System.out.println("Ingrese la fecha de nacimiento ");
			    Date fecha_nac = cargarFecha();
			    System.out.println("Ingrese el codigo postal");
			    int cod_postal=sc.nextInt();
			    query = "insert into ciudad_de_los_niños.padrino (dni,email,tel_fijo,direccion, celular, fecha_nac,cod_postal) values(?,?,?,?,?,?,?)";

			    PreparedStatement statement1 = connection.prepareStatement(query);
			    statement1.setString(1,dni);
			    statement1.setString(2,email);
			    statement1.setString(3,tel_fijo);
			    statement1.setString(4,direccion);
			    statement1.setString(5,celular);
			    statement1.setDate(6,fecha_nac);
			    statement1.setInt(7,cod_postal);
			    statement1.executeUpdate();
	     	 }
	     	 
		}catch(SQLException sqle) {
    		sqle.printStackTrace();
      		System.err.println("Error connecting: " + sqle);
			throw sqle;    	 
    	 };




	}
	
	public static void cargarDonante(String dni,Connection connection){
		try{
			Scanner sc = new Scanner(System.in);
			

			String query = "select (dni) from ciudad_de_los_niños.donante where (dni='"+dni+"') ";

	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(query);
	    	if (!(resultSet.next())){
				 System.out.println("el donante no esta cargado en la base de datos!");
				System.out.println("ingrese la ocupacion");
				 String ocupacion=sc.nextLine();
			     System.out.println("ingrese la cuil_cuit");
			     String cuil_cuit=sc.nextLine();
			     query = "insert into ciudad_de_los_niños.donante (dni,ocupacion,cuil_cuit) values(?,?,?)";
				 PreparedStatement statement1 = connection.prepareStatement(query);
				 statement1.setString(1,dni);
				 statement1.setString(2,ocupacion);
				 statement1.setString(3,cuil_cuit);
				 statement1.executeUpdate();

	     	 }
	     	 
		}catch(SQLException sqle) {
    		sqle.printStackTrace();
      		System.err.println("Error connecting: " + sqle);
    	 };

	}

	public static int cargarMedioPago(Connection connection)throws SQLException{
			try{
				Scanner sc = new Scanner(System.in);
				System.out.println("Que medio de pago quiere? 1:Tarjeta de Credito 2:Debito");
				int opcion = sc.nextInt();
				int id=0;
				if(opcion==1){id=cargarTarjeta(connection);}
				if(opcion==2){id=cargarDebito(connection);}
		     	return id;
		     
		     	 
			}catch(SQLException sqle) {
	    		sqle.printStackTrace();
	      		System.err.println("Error connecting: " + sqle);
	    	 	throw sqle;
	    	 }

		}

	public static int cargarTarjeta(Connection connection)throws SQLException{
			try{
				Scanner sc = new Scanner(System.in);
				System.out.println("ingrese el numero de la tarjeta");
				String nro_tarjeta = sc.nextLine();
				String query = "select * from ciudad_de_los_niños.Tarjeta where (nro='"+nro_tarjeta+"') ";

	    		Statement statement = connection.createStatement();
	    		ResultSet resultSet = statement.executeQuery(query);
		    	if (!(resultSet.next())){
					 System.out.println("la tarjeta no esta cargado en la base de datos!");
					 System.out.println("ingrese el nombre del titula de la tarjeta");
					 String nombre_titular=sc.nextLine();

					 System.out.println("Ingrese la fecha de vencimiento (Formato dd-mm-aaaa)");
					 Date fecha_vencimiento=cargarFecha();
				    

					 
					 String nombre_tarjeta=cargarTipoTarjeta(connection);
					 
					 System.out.println("ingrese el codigo de verificacion de la tarjeta");
					 int codigo_verificacion=sc.nextInt();
					
					 query = "insert into ciudad_de_los_niños.medio_de_pago (id) values(default)";
					 PreparedStatement statement1 = connection.prepareStatement(query);
					 statement1.executeUpdate();

				     query = "insert into ciudad_de_los_niños.tarjeta (id,nro,nombre_titular,fecha_vencimiento,nombre_tarjeta,codigo_verificacion) values(lastval(),?,?,?,?,?)";
					 statement1= connection.prepareStatement(query);
					 
					 statement1.setString(1,nro_tarjeta);
					 statement1.setString(2,nombre_titular);
					 statement1.setDate(3,fecha_vencimiento);
					 statement1.setString(4,nombre_tarjeta);
					 statement1.setInt(5,codigo_verificacion);
					 statement1.executeUpdate();
					 query = "select * from ciudad_de_los_niños.tarjeta where (nro='"+nro_tarjeta+"');";
					 statement = connection.createStatement();
					 resultSet = statement.executeQuery(query);
		     	 	resultSet.next();
		     	 	return resultSet.getInt("id");
		     	 }else{
		     	 	return resultSet.getInt("id");

		     	 }	
		     
		     	 
			}catch(SQLException sqle) {
	    		sqle.printStackTrace();
	      		System.err.println("Error connecting: " + sqle);
	    	 	throw sqle;
	    	 }

		}
public static int cargarDebito(Connection connection)throws SQLException{
			try{
				Scanner sc = new Scanner(System.in);
				System.out.println("ingrese el CBU");
				String cbu = sc.nextLine();
				String query = "select * from ciudad_de_los_niños.Debito where (CBU='"+cbu+"') ";

	    		Statement statement = connection.createStatement();
	    		ResultSet resultSet = statement.executeQuery(query);
		    	if (!(resultSet.next())){
					 System.out.println(" la cuenta de debito no esta cargado en la base de datos!");
					


					 System.out.println("ingrese el numero de cuenta");
					 int nro_cuenta = sc.nextInt();
					
					 sc.nextLine();


					 System.out.println("ingrese el nombre del titular");
					 String nombre_titular=sc.nextLine();

					 
					 System.out.println("ingrese el codigo de verificacion de la tarjeta");
					 int codigo_verificacion=sc.nextInt();

					 sc.nextLine();

					 System.out.println("ingrese el tipo de cuenta");
					 String tipo_cuenta=sc.nextLine();
					
					 System.out.println("ingrese el nombre del banco");
					String nombre_banco=sc.nextLine();
					 
					 System.out.println("ingrese el nombre de la sucursal");
					 String sucursal_banco=sc.nextLine();

					 query = "insert into ciudad_de_los_niños.medio_de_pago (id) values(default)";
					 PreparedStatement statement1 = connection.prepareStatement(query);
					 statement1.executeUpdate();

				     query = "insert into ciudad_de_los_niños.debito (id,nro_cuenta,cbu,nombre_titular,codigo_verificacion,tipo_cuenta,nombre_banco,sucursal_banco) values(lastval(),?,?,?,?,?,?,?)";
					 statement1= connection.prepareStatement(query);
					 statement1.setInt(1,nro_cuenta);
					 statement1.setString(2,cbu);
					 statement1.setString(3,nombre_titular);
					 statement1.setInt(4,codigo_verificacion);
					 statement1.setString(5,tipo_cuenta);
					 statement1.setString(6,nombre_banco);
					 statement1.setString(7,sucursal_banco);
					 statement1.executeUpdate();
					 query = "select * from ciudad_de_los_niños.debito where (cbu='"+cbu+"') ";
					 statement = connection.createStatement();
					 resultSet = statement.executeQuery(query);
		     	 	resultSet.next();
		     	 	return resultSet.getInt("id");
		     	 }else{
		     	 	return resultSet.getInt("id");

		     	 }	
		     
		     	 
			}catch(SQLException sqle) {
	    		sqle.printStackTrace();
	      		System.err.println("Error connecting: " + sqle);
	    	 	throw sqle;
	    	 }

		}

	public static String cargarTipoTarjeta(Connection connection)throws SQLException{
			try{
				Scanner sc = new Scanner(System.in);
				System.out.println("ingrese el nombre de la tarjeta");
				String nombre_tarjeta = sc.nextLine();
				String query = "select (nombre_tarjeta) from ciudad_de_los_niños.TipoTarjeta where (nombre_tarjeta='"+nombre_tarjeta+"') ";

	    		Statement statement = connection.createStatement();
	    		ResultSet resultSet = statement.executeQuery(query);
		    	if (!(resultSet.next())){

				     query = "insert into ciudad_de_los_niños.TipoTarjeta (nombre_tarjeta) values(?)";
					 PreparedStatement statement1= connection.prepareStatement(query);
					 statement1.setString(1,nombre_tarjeta);
					 statement1.executeUpdate();
		     	 	
		     	 	return nombre_tarjeta;
		     	 }else{
		     	 	return resultSet.getString("nombre_tarjeta");

		     	 }	
		     
		     	 
			}catch(SQLException sqle) {
	    		sqle.printStackTrace();
	      		System.err.println("Error connecting: " + sqle);
	    	 	throw sqle;
	    	 }

		}


		public static void cargarAporta(String dni,String nombre_programa,int id, Connection connection){
		try{
			Scanner sc = new Scanner(System.in);
			

			String query = "select * from ciudad_de_los_niños.aporta where (dni='"+dni+"' AND nombre_programa='"+nombre_programa+"' AND id="+id+") ";

	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(query);
	    	if (!(resultSet.next())){
				 System.out.println("el aporte no esta cargado en la base de datos!");
				 System.out.println("ingrese el monto a aportar");
				 float monto=sc.nextFloat();
			     
			     String frecuencia=tipoFrecuencia();
			     query = "insert into ciudad_de_los_niños.aporta (dni,nombre_programa,monto,frecuencia,id) values(?,?,?,?,?)";
				 PreparedStatement statement1 = connection.prepareStatement(query);
				 statement1.setString(1,dni);
				 statement1.setString(2,nombre_programa);
				 statement1.setFloat(3,monto);
				 statement1.setString(4,frecuencia);
				 statement1.setInt(5,id);
				 statement1.executeUpdate();

	     	 }
	     	 
			}catch(SQLException sqle) {
    		sqle.printStackTrace();
      		System.err.println("Error connecting: " + sqle);
    	 	};

		}

		public static String tipoFrecuencia(){
			Scanner sc = new Scanner(System.in);
			System.out.println("Con que frecuencia va a aportar? \n 1=Mensual \n 2=Semestral");
			int opcion =sc.nextInt();
			while(opcion!=1 &&opcion!=2){
				System.out.println("Con que frecuencia va a aportar? \n 1=Mensual \n 2=Semestral");
				 opcion =sc.nextInt();
			};
			if(opcion==1){
				return "Mensual";
				}else{
					return "Semestral";}
		   
			
		}

		public static String cargarPrograma(Connection connection)throws SQLException{
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("ingrese nombre del programa al que desea aportar");
			String nombre_programa =sc.nextLine();

			String query = "select (nombre_programa) from ciudad_de_los_niños.Programa where (nombre_programa='"+nombre_programa+"') ";

	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(query);
	    	if (!(resultSet.next())){
				 System.out.println("el programa no esta cargado en la base de datos!");
				System.out.println("ingrese la descripcion del programa");
				 String descripcion=sc.nextLine();
			     query = "insert into ciudad_de_los_niños.programa (nombre_programa,descripcion) values(?,?)";
				 PreparedStatement statement1 = connection.prepareStatement(query);
				 statement1.setString(1,nombre_programa);
				 statement1.setString(2,descripcion);
				 statement1.executeUpdate();
	     	 }
	     	return nombre_programa; 
		}catch(SQLException sqle) {
    		sqle.printStackTrace();
      		System.err.println("Error connecting: " + sqle);
    	 	throw sqle;
    		 }

		}


	public static void eliminarDonante(Connection connection)throws SQLException{
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("ingrese dni del donante que desea ELIMINAR");
			String dni =sc.nextLine();

			String query = "delete from ciudad_de_los_niños.donante where (dni='"+dni+"')";

	    	PreparedStatement statement = connection.prepareStatement(query);
	    	statement.executeUpdate();
	    	 
		}catch(SQLException sqle) {
    		sqle.printStackTrace();
      		System.err.println("Error connecting: " + sqle);
    	 	throw sqle;
    	 }

	}


	public static void listarDonantes(Connection connection)throws SQLException{
		try{
			
			String query = "select dni,n_y_ap,nombre_programa,monto,frecuencia from ciudad_de_los_niños.persona natural join ciudad_de_los_niños.aporta";

	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(query);
	    	
			System.out.println("\n \n \n ");
	    	while((resultSet.next())){
				String dni= resultSet.getString("dni");
				String nombre= resultSet.getString("n_y_ap");
				String nom_prog= resultSet.getString("nombre_programa");
				float monto= resultSet.getFloat("monto");
				String frecuencia = resultSet.getString("frecuencia");

				System.out.println("DNI: "+dni);
				System.out.println("Nombre y apellido: "+nombre);
				System.out.println("Programa al que aporta: "+nom_prog);
				System.out.println("Monto: "+monto);
				System.out.println("Freciencia: "+frecuencia);
				System.out.println("------------------------------------------------------------");



	     	 }
	     	 
		}catch(SQLException sqle) {
    		sqle.printStackTrace();
      		System.err.println("Error connecting: " + sqle);
    	 	throw sqle;
    		 }

		}


	public static Date cargarFecha(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Ingrese el DIA:");
		int dia = sc.nextInt();
		System.out.println("Ingrese el MES:");
		int mes = sc.nextInt();
		System.out.println("Ingrese el AÑO:");
		int año = sc.nextInt();
		Date fecha = new Date ((año-1900),(mes-1),dia);
		return fecha;



	}












}










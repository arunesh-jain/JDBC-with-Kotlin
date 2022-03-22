import java.sql.DriverManager

// the model class
data class User(val id: Int, val name: String)

fun main(){

    val jdbcUrl = "jdbc:mysql://localhost:3306/kotlin" //JDBC URL

    // get the connection
    val connection = DriverManager
        .getConnection(jdbcUrl, "javaintern", "Password@123")

    // prints true if the connection is valid
    println(connection.isValid(0))  //true

    // the query is only prepared not executed
    val query = connection.prepareStatement("SELECT * FROM users")

    // the query is executed and results are fetched
    val result = query.executeQuery()

    // an empty list for holding the results
    val users = mutableListOf<User>()

    while(result.next()){

        // getting the value of the id column
        val id = result.getInt("id")

        // getting the value of the name column
        val name = result.getString("name")

        /*
        constructing a User object and
        putting data into the list
         */
        users.add(User(id, name))
    }
    /*
    [User(id=1, name=Arunesh), User(id=2, name=Surbhi),
    User(id=3, name=Prateek), User(id=4, name=Aman)]
     */
    println(users)
}
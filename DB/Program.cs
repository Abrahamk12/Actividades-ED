using System;
using System.IO;
using System.Data.SQLite;
using System.Collections.Generic;
public class DatabaseManager
{
    private readonly string _connectionString;

    public DatabaseManager(string dbPath)
    {
        _connectionString = $"Data Source={dbPath};Version=3;";
    }

    private void ExecuteNonQuery(string query, Dictionary<string, object> parameters = null)
    {
        using (SQLiteConnection connection = new SQLiteConnection(_connectionString))
        {
            connection.Open();
            using (SQLiteCommand command = new SQLiteCommand(query, connection))
            {
                if (parameters != null)
                {
                    foreach (var param in parameters)
                    {
                        command.Parameters.AddWithValue(param.Key, param.Value);
                    }
                }
                command.ExecuteNonQuery();
            }
        }
    }


    // Método para CREATE TABLE
    public void CreateTable(string tableName, string columns)
    {
        string query = $"CREATE TABLE IF NOT EXISTS {tableName} ({columns})";
        ExecuteNonQuery(query);
    }

    // Método para INSERT INTO
    public void InsertInto(string tableName, Dictionary<string, object> values)
    {
        string columns = string.Join(", ", values.Keys);
        string placeholders = string.Join(", ", values.Keys).Replace(",", ", @");
        string query = $"INSERT INTO {tableName} ({columns}) VALUES (@{placeholders})";
        ExecuteNonQuery(query, values);
    }

    // Método para UPDATE
    public void Update(string tableName, Dictionary<string, object> values, string condition)
    {
        string setClause = string.Join(", ", values.Keys) + "=@..."; //<col in DB > like Eg Main Name=
    }
    public void ModifyTableStructure(string oldTableName, string newTableName, string newTableDefinition)
    {
        using (SQLiteConnection connection = new SQLiteConnection(_connectionString))
        {
            connection.Open();

            // Paso 1: Crear una nueva tabla
            string createNewTableQuery = $"CREATE TABLE {newTableName} ({newTableDefinition})";
            using (SQLiteCommand command = new SQLiteCommand(createNewTableQuery, connection))
            {
                command.ExecuteNonQuery();
                Console.WriteLine($"¡Tabla {newTableName} creada!");
            }

            // Paso 2: Copiar datos a la nueva tabla
            string copyDataQuery = $"INSERT INTO {newTableName} SELECT * FROM {oldTableName}";
            using (SQLiteCommand command = new SQLiteCommand(copyDataQuery, connection))
            {
                command.ExecuteNonQuery();
                Console.WriteLine($"¡Datos copiados de {oldTableName} a {newTableName}!");
            }

            // Paso 3: Eliminar la tabla original
            string dropOldTableQuery = $"DROP TABLE {oldTableName}";
            using (SQLiteCommand command = new SQLiteCommand(dropOldTableQuery, connection))
            {
                command.ExecuteNonQuery();
                Console.WriteLine($"¡Tabla {oldTableName} eliminada!");
            }

            // Paso 4: Renombrar la nueva tabla
            string renameTableQuery = $"ALTER TABLE {newTableName} RENAME TO {oldTableName}";
            using (SQLiteCommand command = new SQLiteCommand(renameTableQuery, connection))
            {
                command.ExecuteNonQuery();
                Console.WriteLine($"¡Tabla renombrada de {newTableName} a {oldTableName}!");
            }
        }
    }

    public List<Dictionary<string, object>> SelectFrom(string tableName, string columns, string whereCondition = null, Dictionary<string, object> parameters = null)
    {
        var results = new List<Dictionary<string, object>>();
        string query = $"SELECT {columns} FROM {tableName}";

        // Agregar cláusula WHERE si se especifica
        if (!string.IsNullOrEmpty(whereCondition))
        {
            query += $" WHERE {whereCondition}";
        }

        using (SQLiteConnection connection = new SQLiteConnection(_connectionString))
        {
            connection.Open();
            using (SQLiteCommand command = new SQLiteCommand(query, connection))
            {
                // Agregar parámetros al comando si se proporcionan
                if (parameters != null)
                {
                    foreach (var param in parameters)
                    {
                        command.Parameters.AddWithValue(param.Key, param.Value);
                    }
                }

                using (SQLiteDataReader reader = command.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        var row = new Dictionary<string, object>();
                        for (int i = 0; i < reader.FieldCount; i++)
                        {
                            row[reader.GetName(i)] = reader.GetValue(i);
                        }
                        results.Add(row);
                    }
                }
            }
        }

        return results;
    }

}
class Program
{
    static void Main()
    {
        string dbPath = "TuBaseDeDatos.sqlite"; // Ruta de tu base de datos

        // Verificar si el archivo de la base de datos ya existe
        if (!File.Exists(dbPath))
        {
            // Si no existe, crear la base de datos
            SQLiteConnection.CreateFile(dbPath);
            Console.WriteLine("¡Base de datos creada!");

            // Crear una tabla inicial en la base de datos
            using (SQLiteConnection connection = new SQLiteConnection($"Data Source={dbPath};Version=3;"))
            {
                connection.Open();
                string createTableQuery = "CREATE TABLE IF NOT EXISTS Usuarios (Id INTEGER PRIMARY KEY, Nombre TEXT)";
                using (SQLiteCommand command = new SQLiteCommand(createTableQuery, connection))
                {
                    command.ExecuteNonQuery();
                    Console.WriteLine("¡Tabla creada!");
                }
            }
        }
        else
        {
            Console.WriteLine("La base de datos ya existe.");
        }

    }

}



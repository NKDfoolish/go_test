import psycopg2
import os

def bulk_insert_to_postgres(csv_file_path, table_name, db_config, columns):
    """
    Import large CSV data into PostgreSQL using COPY command.

    :param csv_file_path: Path to the CSV file
    :param table_name: Target table in PostgreSQL
    :param db_config: Dictionary containing database connection parameters
    :param columns: List of columns to insert data into
    """
    try:
        # Connect to PostgreSQL
        conn = psycopg2.connect(
            dbname=db_config['dbname'],
            user=db_config['user'],
            password=db_config['password'],
            host=db_config['host'],
            port=db_config['port']
        )
        cursor = conn.cursor()

        # Open the CSV file
        with open(csv_file_path, 'r', encoding='utf-8') as f:
            # Use COPY command to load data into specific columns
            column_list = ', '.join(columns)
            cursor.copy_expert(f"COPY {table_name} ({column_list}) FROM STDIN WITH CSV HEADER", f)
        
        # Commit the transaction
        conn.commit()
        print(f"Data successfully imported into table '{table_name}'.")

    except Exception as e:
        print(f"Error: {e}")
        if conn:
            conn.rollback()
    finally:
        # Close the connection
        if cursor:
            cursor.close()
        if conn:
            conn.close()

if __name__ == "__main__":
    # Configuration for PostgreSQL
    db_config = {
        'dbname': 'exam_db',
        'user': 'postgres',
        'password': 'postgres',
        'host': 'localhost',  # Change to your host if needed
        'port': 5432          # Default PostgreSQL port
    }

    # File and table details for students
    csv_file_path_students = 'students.csv'
    table_name_students = 'students'
    columns_students = ['student_id', 'no_language']

    # Import students data
    bulk_insert_to_postgres(csv_file_path_students, table_name_students, db_config, columns_students)

    # File and table details for scores
    csv_file_path_scores = 'scores.csv'
    table_name_scores = 'scores'
    columns_scores = ['student_id', 'subject', 'score']  # Exclude the 'id' column

    # Import scores data
    bulk_insert_to_postgres(csv_file_path_scores, table_name_scores, db_config, columns_scores)
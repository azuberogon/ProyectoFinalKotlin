import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.dallyproject.hugo.ActividadEntity
/**
 * Data Access Object (DAO) para la entidad ActividadEntity.
 * Esta interfaz define métodos para interactuar con la base de datos
 * relacionados con la entidad ActividadEntity.
 */
@Dao
interface ActividadDAO {

    /**
     * Obtiene todas las actividades almacenadas en la base de datos.
     *
     * @return Lista de todas las actividades almacenadas.
     */
    @Query("SELECT * FROM actividadentity")
    fun getAll(): List<ActividadEntity>

    /**
     * Busca una actividad por su nombre en la base de datos.
     *
     * @param nombreEntrada El nombre de la actividad a buscar.
     * @return La actividad encontrada, o null si no se encuentra ninguna coincidencia.
     */
    @Query("SELECT * FROM actividadentity WHERE nombre = :nombreEntrada LIMIT 1")
    fun findByName(nombreEntrada: String): ActividadEntity?

    /**
     * Inserta una nueva actividad en la base de datos.
     *
     * @param entity La entidad de la actividad a insertar.
     * @return El ID de la actividad recién insertada.
     */
    @Insert
    fun insert(entity: ActividadEntity): Long

    /**
     * Elimina una actividad de la base de datos.
     *
     * @param entity La entidad de la actividad a eliminar.
     */
    @Delete
    fun delete(entity: ActividadEntity)

    /**
     * Elimina todas las actividades de la base de datos.
     */
    @Query("DELETE FROM actividadentity")
    fun deleteAll()
}
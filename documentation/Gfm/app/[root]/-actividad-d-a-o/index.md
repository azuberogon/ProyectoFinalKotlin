//[app](../../../index.md)/[[root]](../index.md)/[ActividadDAO](index.md)

# ActividadDAO

[androidJvm]\
interface [ActividadDAO](index.md)

Data Access Object (DAO) para la entidad ActividadEntity. Esta interfaz define métodos para interactuar con la base de datos relacionados con la entidad ActividadEntity.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract fun [delete](delete.md)(entity: [ActividadEntity](../../com.example.dallyproject.hugo/-actividad-entity/index.md))<br>Elimina una actividad de la base de datos. |
| [deleteAll](delete-all.md) | [androidJvm]<br>abstract fun [deleteAll](delete-all.md)()<br>Elimina todas las actividades de la base de datos. |
| [findByName](find-by-name.md) | [androidJvm]<br>abstract fun [findByName](find-by-name.md)(nombreEntrada: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ActividadEntity](../../com.example.dallyproject.hugo/-actividad-entity/index.md)?<br>Busca una actividad por su nombre en la base de datos. |
| [getAll](get-all.md) | [androidJvm]<br>abstract fun [getAll](get-all.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ActividadEntity](../../com.example.dallyproject.hugo/-actividad-entity/index.md)&gt;<br>Obtiene todas las actividades almacenadas en la base de datos. |
| [insert](insert.md) | [androidJvm]<br>abstract fun [insert](insert.md)(entity: [ActividadEntity](../../com.example.dallyproject.hugo/-actividad-entity/index.md)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Inserta una nueva actividad en la base de datos. |

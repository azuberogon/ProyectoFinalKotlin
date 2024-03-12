//[app](../../../index.md)/[com.example.dallyproject.imanol](../index.md)/[TematicasDAO](index.md)

# TematicasDAO

[androidJvm]\
interface [TematicasDAO](index.md)

Data Access Object (DAO) para la entidad TematicaEntity. Proporciona métodos para acceder a la base de datos y realizar operaciones CRUD en la tabla TematicaEntity.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract fun [delete](delete.md)(tematica: [TematicaEntity](../-tematica-entity/index.md))<br>Elimina una temática de la tabla TematicaEntity. |
| [deleteAll](delete-all.md) | [androidJvm]<br>abstract fun [deleteAll](delete-all.md)()<br>Elimina todos los registros de la tabla TematicaEntity. |
| [findByNameandLugar](find-by-nameand-lugar.md) | [androidJvm]<br>abstract fun [findByNameandLugar](find-by-nameand-lugar.md)(first: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), last: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [TematicaEntity](../-tematica-entity/index.md)<br>Busca una temática por nombre y lugar. |
| [getAll](get-all.md) | [androidJvm]<br>abstract fun [getAll](get-all.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TematicaEntity](../-tematica-entity/index.md)&gt;<br>Obtiene todos los registros de la tabla TematicaEntity. |
| [insertAll](insert-all.md) | [androidJvm]<br>abstract fun [insertAll](insert-all.md)(vararg tematicas: [TematicaEntity](../-tematica-entity/index.md)): [LongArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)<br>Inserta una lista de temáticas en la tabla TematicaEntity. |
| [loadAllByNames](load-all-by-names.md) | [androidJvm]<br>abstract fun [loadAllByNames](load-all-by-names.md)(userNames: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TematicaEntity](../-tematica-entity/index.md)&gt;<br>Carga todas las temáticas por nombres. |

//[app](../../../index.md)/[com.example.dallyproject.imanol](../index.md)/[SignUpDAO](index.md)

# SignUpDAO

[androidJvm]\
interface [SignUpDAO](index.md)

Data Access Object (DAO) para la entidad SignUpEntity. Proporciona métodos para acceder a la base de datos y realizar operaciones CRUD en la tabla SignUpEntity.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract fun [delete](delete.md)(entity: [SignUpEntity](../-sign-up-entity/index.md))<br>Elimina un registro de la tabla SignUpEntity. |
| [deleteAll](delete-all.md) | [androidJvm]<br>abstract fun [deleteAll](delete-all.md)()<br>Elimina todos los registros de la tabla SignUpEntity. |
| [findByUsername](find-by-username.md) | [androidJvm]<br>abstract fun [findByUsername](find-by-username.md)(username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SignUpEntity](../-sign-up-entity/index.md)?<br>Busca un usuario por nombre de usuario. |
| [findByUsernameAndPassword](find-by-username-and-password.md) | [androidJvm]<br>abstract fun [findByUsernameAndPassword](find-by-username-and-password.md)(username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SignUpEntity](../-sign-up-entity/index.md)?<br>Busca un usuario por nombre de usuario y contraseña. |
| [getAll](get-all.md) | [androidJvm]<br>abstract fun [getAll](get-all.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[SignUpEntity](../-sign-up-entity/index.md)&gt;<br>Obtiene todos los registros de la tabla SignUpEntity. |
| [insert](insert.md) | [androidJvm]<br>abstract fun [insert](insert.md)(entity: [SignUpEntity](../-sign-up-entity/index.md))<br>Inserta un nuevo registro en la tabla SignUpEntity. |

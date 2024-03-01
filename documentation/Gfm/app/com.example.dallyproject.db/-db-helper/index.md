//[app](../../../index.md)/[com.example.dallyproject.db](../index.md)/[DbHelper](index.md)

# DbHelper

[androidJvm]\
open class [DbHelper](index.md) : [SQLiteOpenHelper](https://developer.android.com/reference/kotlin/android/database/sqlite/SQLiteOpenHelper.html)

## Constructors

| | |
|---|---|
| [DbHelper](-db-helper.md) | [androidJvm]<br>constructor(@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Properties

| Name | Summary |
|---|---|
| [TABLE_CONTACTOS](-t-a-b-l-e_-c-o-n-t-a-c-t-o-s.md) | [androidJvm]<br>val [TABLE_CONTACTOS](-t-a-b-l-e_-c-o-n-t-a-c-t-o-s.md): [String](https://developer.android.com/reference/kotlin/java/lang/String.html) = &quot;t_inicioDeSesion&quot; |

## Functions

| Name | Summary |
|---|---|
| [autenticar](autenticar.md) | [androidJvm]<br>open fun [autenticar](autenticar.md)(nombreUser: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), contrasenia: [String](https://developer.android.com/reference/kotlin/java/lang/String.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [buscarUsuario](buscar-usuario.md) | [androidJvm]<br>open fun [buscarUsuario](buscar-usuario.md)(nombre: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), contrasenia: [String](https://developer.android.com/reference/kotlin/java/lang/String.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [close](index.md#-1132609887%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [close](index.md#-1132609887%2FFunctions%2F-912451524)() |
| [crearUsuario](crear-usuario.md) | [androidJvm]<br>open fun [crearUsuario](crear-usuario.md)(nombre: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), contrasenia: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), numTelefono: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), correoElectronico: [String](https://developer.android.com/reference/kotlin/java/lang/String.html)): [Boolean](https://developer.android.com/reference/kotlin/java/lang/Boolean.html) |
| [getDatabaseName](index.md#2092117245%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [getDatabaseName](index.md#2092117245%2FFunctions%2F-912451524)(): [String](https://developer.android.com/reference/kotlin/java/lang/String.html) |
| [getReadableDatabase](index.md#725964472%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [getReadableDatabase](index.md#725964472%2FFunctions%2F-912451524)(): [SQLiteDatabase](https://developer.android.com/reference/kotlin/android/database/sqlite/SQLiteDatabase.html) |
| [getWritableDatabase](index.md#-1273172728%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [getWritableDatabase](index.md#-1273172728%2FFunctions%2F-912451524)(): [SQLiteDatabase](https://developer.android.com/reference/kotlin/android/database/sqlite/SQLiteDatabase.html) |
| [onConfigure](index.md#-1648481475%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [onConfigure](index.md#-1648481475%2FFunctions%2F-912451524)(db: [SQLiteDatabase](https://developer.android.com/reference/kotlin/android/database/sqlite/SQLiteDatabase.html)) |
| [onCreate](on-create.md) | [androidJvm]<br>open fun [onCreate](on-create.md)(db: [SQLiteDatabase](https://developer.android.com/reference/kotlin/android/database/sqlite/SQLiteDatabase.html)) |
| [onDowngrade](index.md#-1371251722%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [onDowngrade](index.md#-1371251722%2FFunctions%2F-912451524)(db: [SQLiteDatabase](https://developer.android.com/reference/kotlin/android/database/sqlite/SQLiteDatabase.html), oldVersion: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), newVersion: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onOpen](index.md#-653481789%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [onOpen](index.md#-653481789%2FFunctions%2F-912451524)(db: [SQLiteDatabase](https://developer.android.com/reference/kotlin/android/database/sqlite/SQLiteDatabase.html)) |
| [onUpgrade](on-upgrade.md) | [androidJvm]<br>open fun [onUpgrade](on-upgrade.md)(db: [SQLiteDatabase](https://developer.android.com/reference/kotlin/android/database/sqlite/SQLiteDatabase.html), oldVersion: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), newVersion: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [setIdleConnectionTimeout](index.md#-1771995752%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [setIdleConnectionTimeout](index.md#-1771995752%2FFunctions%2F-912451524)(idleConnectionTimeoutMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setLookasideConfig](index.md#2096357599%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [setLookasideConfig](index.md#2096357599%2FFunctions%2F-912451524)(slotSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), slotCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [setOpenParams](index.md#-627348398%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [setOpenParams](index.md#-627348398%2FFunctions%2F-912451524)(openParams: [SQLiteDatabase.OpenParams](https://developer.android.com/reference/kotlin/android/database/sqlite/SQLiteDatabase.OpenParams.html)) |
| [setWriteAheadLoggingEnabled](index.md#894718087%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [setWriteAheadLoggingEnabled](index.md#894718087%2FFunctions%2F-912451524)(enabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [test](test.md) | [androidJvm]<br>open fun [test](test.md)() |

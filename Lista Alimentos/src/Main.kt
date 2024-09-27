import java.util.Scanner

fun main() {
    // Se define la varíable de solo lectura, alimentos, que es un mapa de alimentos y sus calorías
    val alimentos = mapOf(
        "Pizza" to 800,
        "Ensalada" to 200,
        "Hamburguesa" to 700,
        "Manzana" to 100,
        "Helado" to 300,
        "Pasta" to 600,
        "Yogurt" to 150
    )

    val scanner = Scanner(System.`in`)

    while (true) {
        // Agrega el bucle para mostrar el menú y leer la entrada del usuario.
        println("Favor de introducir el número respecto a la opción a mostrar (1-4):")
        println("1. Catálogo completo de alimentos y sus calorias")
        println("2. Solo alimentos con pocas calorias")
        println("3. Solo alimentos con muchas calorias")
        println("4. Total de calorías consumidas en un día")

        // Lee la entrada del usuario y maneja las excepciones
        val choice = try {
            scanner.nextInt()
        } catch (e: Exception) {
            scanner.nextLine() // Clear the invalid input
            println("Opción invalida: Introduce una opción del 1 al 4.")
            continue
        }

        // Usa la declaración when para llamar a la función correspondiente según la opción elegida
        when (choice) {
            1 -> {
                printCatalog(alimentos)
                promptEnterKey()
                continue
            }
            2 -> printLowCalorieFoods(alimentos)
            3 -> printHighCalorieFoods(alimentos)
            4 -> {
                printTotalCalories(alimentos)
                promptEnterKey()
                continue
            }
            else -> {
                println("Opción invalida: Introduce una opción del 1 al 4.")
                continue
            }
        }
    }
}

// Función para imprimir el catálogo completo de alimentos y sus calorías
fun printCatalog(alimentos: Map<String, Int>) {
    println("Catalogo de alimentos y sus calorías:")
    for ((food, calories) in alimentos) {
        println("$food: $calories calorías")
    }
}

// Función para imprimir alimentos con bajas calorías (menos de 500)
fun printLowCalorieFoods(alimentos: Map<String, Int>) {
    println("Alimentos con bajas calorías (menos de 300 calorías):")
    for ((food, calories) in alimentos) {
        if (calories < 500) {
            println("$food: $calories calorías")
        }
    }
}

// Función para imprimir alimentos con altas calorías (500 o más)
fun printHighCalorieFoods(alimentos: Map<String, Int>) {
    println("Alimentos con altas calorías (300 o más calorías):")
    for ((food, calories) in alimentos) {
        if (calories >= 500) {
            println("$food: $calories calorías")
        }
    }
}

// Función para imprimir el total de calorías consumidas en un día
fun printTotalCalories(alimentos: Map<String, Int>) {
    val foodsConsumed = listOf("Ensalada", "Manzana", "Pasta", "Yogurt")
    var totalCalories = 0
    for (food in foodsConsumed) {
        totalCalories += alimentos[food] ?: 0
    }
    println("Total de calorías consumidas en el día: $totalCalories")
}

// Función para mostrar un mensaje y esperar a que el usuario presione Enter, y así regresar al menú principal
fun promptEnterKey() {
    println("Presiona Enter para regresar al menú principal...")
    readLine()
}
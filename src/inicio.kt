import java.lang.NumberFormatException

fun main() {
    val listaIngredientes : List<String> = listOf<String>(
        "Pollo",
        "Cerdo",
        "Pescado",
        "Res",
        "Chuleta Vegana",
        "Pan de Centeno",
        "Pan de Maíz",
        "Tortilla",
        "Arepa",
        "Pan Libre de Glúten","Tomate",
        "Lechuga",
        "Cebolla")
    var listaMercado : MutableList<String>? = mutableListOf()//Esta lista la lleno con los productos
    val listaReceta : MutableList<String>? = mutableListOf()//En esta lista van los nombres de las recetas
    val listaIng : MutableList<String>? = mutableListOf()//En esta lista descargo el valor de lista mercado

    //Ciclo Principal
    iraMenuPrincipal@ while (true){

        println("""
               /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
               Bienvenidos a Recipe Maker!
               by Andrés!
               
               M E N Ú  P R I N C I P A L: 
               
               Selecciona la Opción Deseada
               
               Hacer una Receta...............1 
               Ver mis Recetas................2
               Salir..........................3
               /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/""".trimMargin())

        println("Tu Opción Es?:")
        val opcionPrin:String? = readLine()

        //Primera Opción
        if (opcionPrin.equals("1")){

            //Ciclo Menú Receta
            menuReceta@while (true) {

                println("Ingrese el Nombre de Su Receta:")
                val nomReceta: String? = readLine()

                if (nomReceta.isNullOrBlank() && nomReceta.isNullOrEmpty()) {

                    println(
                        """
                            /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
                                                       

                                    NO PUEDES DEJAR EL NOMBRE VACIO                                                       
                                                       
                             
                             /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
                             """.trimIndent()
                    )
                    continuarPausa()

                    /////////////////////////////////////////////////////////////////////////////////////////
                    borrarIndiceLista(listaIng!!, listaReceta!!)
                    /////////////////////////////////////////////////////////////////////////////////////////
                    continue@iraMenuPrincipal

                } else {

                    listaReceta!!.add(nomReceta)

                }


                println("Cuantos Ingredientes va a tener tu receta:")

                val numIngReceta: String? = readLine()

                try {
                    //casteo el número de String a Int
                    val castNIR = numIngReceta!!.toInt()
                    castNIR.div(1)

                }catch (e: NumberFormatException){

                    println(
                        """
                                /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
                                                           
    
                                        Tienes que indicar un Número                                                       
                                                           
                                 
                                 /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
                                 """.trimIndent())
                    continuarPausa()

                    /////////////////////////////////////////////////////////////////////////////////////////
                    borrarIndiceLista(listaIng!!, listaReceta)
                    /////////////////////////////////////////////////////////////////////////////////////////

                    continue@iraMenuPrincipal

                }

                if (numIngReceta.isNullOrBlank() && numIngReceta.isNullOrEmpty()) {

                    println(
                        """
                                /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
                                                           
    
                                        Tienes que indicar un Número                                                       
                                                           
                                 
                                 /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
                                 """.trimIndent())
                    continuarPausa()


                    /////////////////////////////////////////////////////////////////////////////////////////
                    borrarIndiceLista(listaIng!!, listaReceta)
                    /////////////////////////////////////////////////////////////////////////////////////////

                    continue@iraMenuPrincipal


                }else {


                    val numIngRCast = numIngReceta.toInt()
                    var i = 0
                    IngredienteSol@while (i < numIngRCast) {
                        ///////////////////////////////////////////////////////////////////////
                        makeRecipe(listaIngredientes)
                        ///////////////////////////////////////////////////////////////////////
                        val indiceIng = readLine() ?: continue@menuReceta

                        try {

                            val prueba = indiceIng.toInt()

                        }catch (e: NumberFormatException){

                            /////////////////////////////////////////////////////////////////////////////////////////
                            borrarIndiceLista(listaIng!!, listaReceta)
                            /////////////////////////////////////////////////////////////////////////////////////////

                            continue@menuReceta

                        }

                        //
                        val numIn: Int = indiceIng.toInt()
                        if (numIn < 12) {

                            val cont = i + 1
                            println("ingrediente número: $cont")
                            listaMercado?.add(listaIngredientes[numIn])

                            println(listaMercado)
                            continuarPausa()


                            i = i.inc()
                        } else {

                            println("El número máximo del indice es ${listaIngredientes.size}...")
                            continuarPausa()
                            continue@IngredienteSol
                        }


                    }

                    //Agrego la Lista a la Lista Mercado
                    listaIng!!.add(listaMercado.toString())

                    println(
                        """
                           /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
                           
                           
                           FELICIDADES!
                           
                           Tu Receta: $nomReceta, ha sido Agredada con éxito
                           
                           
                           
                           /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
                           """.trimIndent())



                    //Limpio la Lista temporal
                    listaMercado!!.clear()

                    continuarPausa()

                    continue@iraMenuPrincipal

                }
            }


        }else if(opcionPrin.equals("2")){

            if(listaReceta.isNullOrEmpty()||listaReceta.isNullOrEmpty()){

                println(
                    """
                           /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
                           
                           
                            Aún No Tienes Recetas!!                           
                           
                           
                           /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
                           """.trimIndent())
                continuarPausa()

                continue@iraMenuPrincipal
            }else {
                ///////////////////////////////////////////////////////////////////
                viewRecipe(listaReceta, listaIng!!)
                ///////////////////////////////////////////////////////////////////

            }
        }else if(opcionPrin.equals("3")){
            println("\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/")
            println("Saliendo, Hasta Pronto!!!....")
            println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/\n")
            continuarPausa()
            break
        }else{

            println("\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/")
            println("Opción Incorrecta")
            println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/\n")
            continuarPausa()

        }

    }


}

fun continuarPausa(){

    println("Presiona cualquier Tecla para continuar...")
    readLine()

}

fun makeRecipe(listaIngredientes : List <String>){

    println("\n***********Ingredientes Listados***********")
    for ((ind, ing) in listaIngredientes.withIndex()) {

        println("Indice [$ind]: [$ing]")

    }
    println("\n***********Ingredientes Listados***********")
    println("Indique el Número del Ingrediente que desea Agregar")


}

fun viewRecipe(listaReceta : MutableList <String>, listaIng : MutableList <String>){

    println("\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/")
    println("Opción 2")
    println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/\n")

    for ((indx, receta) in listaReceta.withIndex()) {

        println("\nReceta: ${receta}")
        println("Ingredientes: ${listaIng[indx]}\n")


    }

    continuarPausa()

}

fun borrarIndiceLista(listaIng: MutableList<String>, listaReceta: MutableList<String>){

    if (!listaIng.size.equals(listaReceta.size) && listaReceta.size > listaIng.size){

        listaReceta.removeAt(listaReceta.lastIndex)

    }

}
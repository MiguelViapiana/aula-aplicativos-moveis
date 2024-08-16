fun main(){
//    val letras = mutableListOf("A", "B", "C")
//    letras.forEach{l -> println(l)}

    mutableListOf("A", "B", "C").forEach{l -> println(l)}


}



fun main6(){
    val a = 10
    val b = 5

    println("Resultado: ${somar(a, b)}")

}
fun somar(a: Int, b: Int): Int{
    val resultado = a + b
    return resultado
}



fun main5(){
    val vetor01 = intArrayOf(1, 7 ,6)
    val vetor02 = intArrayOf(3, 2, 9)

    val mix = vetor01 + vetor02

    for( n in mix.sorted()){
        //println(n)
    }

    val vetVazioInt = IntArray(5)
    vetVazioInt[0] = 2
    println(vetVazioInt[0])

    val strVetor = arrayOfNulls<String>(5)
    strVetor[0] = "AAAAA"
    println(strVetor[0])
}

fun main4(){
    //exercicio10()

    val letras = mutableListOf("A", "B", "C")

    letras[0] = "H"
    for(l in letras){
        println(l)
    }

//    repeat(40){
//        println("Repeat")
//    }

//    for((i, e) in nomes.withIndex()){
//        println("${i + 1} - $e")
//    }

//    for (i in 1 .. 50){
//        println("Índice $i")
//
//    }
}

fun exercicio07(){
    try {

        println("Digite um número: ")
        val num = readln().toInt()

        //if (num > 100 && num < 200){
        if(num in 101 .. 199){
            println("O número esta no intervalo de 100 a 200")
        }else{
            println("Número fora da faixa")
        }
    }
    catch (e: NumberFormatException){
        println("Number format exception")
    }
}

fun exercicio10(){
    println("Digite um número de 1 a 5")
    val num = readln().toInt()

    when(num){
        1 -> print("Um")
        2-> print("Dois")
        3-> print("Três")
        4-> print("Quatro")
        5-> print("Cinco")
        else -> println("Número inválido")
    }

}





fun main2(){

    println("Digite a nota 1: ")
    val nota1: Int = readln().toInt()
    println("Digite a nota 2: ")
    val nota2: Int = readln().toInt()

    println("Nota 1: $nota1")
    println("Nota 2: $nota2")

    val resultado = (nota1 + nota2) / 2
    println("Resultado: $resultado")
//    if(resultado >= 6){
//        println("Aprovado!!")
//    }else{
//        println("Reprovado")
//    }

//    when(resultado){
//        6 -> println("Aprovado")
//        5-> println("Recuperação")
//        else -> print("Reprovado")
//    }
    when{
        resultado >= 6 -> println("Aprovado")
        //resultado > 1 && resultado < 6 -> println("Recuperação")
        resultado in 1 .. 6 -> println("Recuperaçõa")
        else -> print("Reprovado")
    }

}



fun main1() {
    val a: Int = 10
    var b: Int = 10

    val soma = a + b
    val resto = a - b
    val multiplicado = a * b
    val divisao = a / b


    println("Adição:  $soma")
    println("Subtração:  $resto")
    println("Multiplicação:  $multiplicado")
    println("Divisão:  $divisao")

    if(a >= b){
        println("A maior ou igual a B")
    }else{
        println("A menor que B")
    }



}

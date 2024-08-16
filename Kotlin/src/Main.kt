fun main(){

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

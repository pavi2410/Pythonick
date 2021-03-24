data class Complex(val real: Int, val im: Int) {
    operator fun plus(z: Complex) = Complex(real + z.real, im + z.im)
    fun equals(z: Complex) = real == z.real && im == z.im
}

operator fun Int.plus(z: Complex) = Complex(this + z.real, z.im)
val Int.i get() = Complex(0, this)

fun main() {
    val z = 1 + 2.i
    val z2 = 5 + 5.i
    print(z == z)
}
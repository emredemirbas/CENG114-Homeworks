Emre Demirbaş 21050111069
Ömer Faruk Özüyağlı 21050111047
Muhammed Esat Çelebi 21050111034
Mehmet Ali Yılmaz 21050111057





Explanation about ColorOperator Class

https://www.ecgprod.com/wp-content/uploads/2017/08/basic-primary-colors-of-light-color-wheel.jpg

int[] rgb --> this array represents if any ColorOperator object has red, green or blue inside it.

0th index represents Red
1st index represents Green
2nd index represents Blue

and elements of this array must be 0 or 1.

R G B
1 0 0 ---> Red
0 1 0 ---> Green
0 0 1 ---> Blue
1 0 1 ---> Magenta
1 1 0 ---> Yellow
0 1 1 ---> Cyan
1 1 1 ---> White
0 0 0 ---> Black

Red, Green and Blue are primary colors. ---> determined by determinePrimaryColorOrNot() method.


toDecimal() ---> we implemented this method to calculate distance betwwen two colors.

If you think rgb array as a binary number, this method converts it into decimal number.

For instance, Magenta is represented as [1, 0, 1]. So we convert 101 to decimal, which is 5.


We calculate distance between two colors with subtracting their decimal values.



We used "|" (bitwise) to add two colors. (see line 103 in ColorOperator class.)


In substraction, primary colors can only be subtracted from itself. (see line 115)

For the other colors, we used "^" (bitwise). But please note that we can't subtract 1 from 0. (see lines between 119-125)


In multiplication, we used "&". Multiplication simply returns a common color between two ColorOperators.
For instance, Magenta * Cyan = Blue.

---------------------------------------------------------------------------------------------------------------------------

Also we handle mixed typed Operator array. (See lines 283-295 in Main class.)











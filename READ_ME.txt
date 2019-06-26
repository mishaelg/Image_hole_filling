This is a simple image manuplation project using java.

this programm takes two RGB image, an image and a mask, and creates 1 single grayscale image with "hole"(denotes as -1) where in masks locations.
than, the programm automaticallyfills the hole using specializedalgorithms, and writes it back to the designated location.

input args: image location, mask location, z for weight function, epsilon for weight function, 4 or 8 boundary rule allocator:default is 4, type in "eight" to set as eight, and the "corrected" image location.

output: the corrected image.
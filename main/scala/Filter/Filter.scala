package Filter

import Image.Image

trait Filter {
    def apply(Image: Image): Image
}

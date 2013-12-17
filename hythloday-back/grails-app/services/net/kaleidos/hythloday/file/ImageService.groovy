package net.kaleidos.hythloday.file

import org.imgscalr.Scalr
import javax.imageio.ImageIO

class ImageService {
    def fileService

    static FORMAT = "jpg"

    public uploadForceSize(InputStream inputStream, String path, String name, Integer width = 150, Integer height = 150) {
        def image = ImageIO.read(inputStream)
        def imageWidth = image.getWidth()
        def imageHeight = image.getHeight()
        def fix

        if (imageWidth > imageHeight) {
            fix = Scalr.Mode.FIT_TO_HEIGHT
        } else {
            fix = Scalr.Mode.FIT_TO_WIDTH
        }

        def thumbnailResize = Scalr.resize(image, Scalr.Method.AUTOMATIC, fix, width, height);
        def thumbnail = Scalr.crop(thumbnailResize, 0, 0, width, height)

        def is = converToInputStream(thumbnail)

        return fileService.create(is, path, name)
    }

    public uploadForceWidth(InputStream inputStream, String path, String name, Integer width = 150) {
        def image = ImageIO.read(inputStream)
        def imageWidth = image.getWidth()
        def imageHeight = image.getHeight()

        def fix = Scalr.Mode.FIT_TO_WIDTH
 
        def thumbnail = Scalr.resize(image, Scalr.Method.AUTOMATIC, fix, width);

        def is = converToInputStream(thumbnail)

        return fileService.create(is, path, name)
    }


    private converToInputStream(image) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, FORMAT, os);
        def is = new ByteArrayInputStream(os.toByteArray());

        return is
    }
}
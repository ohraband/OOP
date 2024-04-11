package Export
import Image.{Image, StringImage}
import TableConversion.ConversionTable

//trait for exporting images
trait ImageExport {
      def export(AsciiString: StringImage): Unit = {}
}

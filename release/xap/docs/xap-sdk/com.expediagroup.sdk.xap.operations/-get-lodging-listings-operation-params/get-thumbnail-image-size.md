//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingListingsOperationParams](index.md)/[getThumbnailImageSize](get-thumbnail-image-size.md)

# getThumbnailImageSize

[JVM]\

public final [GetLodgingListingsOperationParams.ThumbnailImageSize](-thumbnail-image-size/index.md)[getThumbnailImageSize](get-thumbnail-image-size.md)()

Indicate what size of image will be used for the single `thumbnail` image that is returned when `contentDetails` is set to `low`, `medium` or `high`.  The available thumbnail image sizes are: - t : Thumbnail - s : Small - b : Big - y : 500x500v - z : 1000x1000v  Resolution from smallest to largest is t < s < b < y < z.  If no `thumbnailImageSize` is specified, the t size images will be returned.  if no thumbnail image found, it would not return thumbnail image.  Only one thumbnail image size is allowed.

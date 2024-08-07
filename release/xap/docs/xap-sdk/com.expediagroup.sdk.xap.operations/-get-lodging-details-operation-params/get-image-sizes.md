//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingDetailsOperationParams](index.md)/[getImageSizes](get-image-sizes.md)

# getImageSizes

[JVM]\

public final [GetLodgingDetailsOperationParams.ImageSizes](-image-sizes/index.md)[getImageSizes](get-image-sizes.md)()

Indicate what size of image will be returned.  The available image sizes are: - t : Thumbnail - s : Small - b : Big - y : 500x500v - z : 1000x1000v  Resolution from smallest to largest is t < s < b < y < z.  If no `imageSizes` is specified, the t size images will be returned.  If an image is missing in one size, we will try to fall back to the same image with lower resolution.  (If image \&quot;_z\&quot; is not available, we will try to return image \&quot;_y\&quot;, and if it is also unavailable, we will return image \&quot;_b\&quot;, and so on.)  Only one image size is allowed.

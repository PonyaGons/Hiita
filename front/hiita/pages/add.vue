<template>
    <v-main>
    <div class="omikuji-img">
        <!-- Image Upload input -->
        <div v-show="!omikujiImg" class="img_post">
            <label for="file" class="img_post_label">画像
                <input id="file" ref="fileInput" type="file" accept=".jpeg, .png" @change="attachImg">
            </label>
        </div>
        <!-- Preview -->
        <div v-show="omikujiImg" class="img_preview">
            <div class="img_preview_circle" @click="clearAttachImg">
                <span class="img_preview_circle_close-icon">［取り消し］</span>
            </div>
            <img :src="omikujiImg" class="img_preview_img">
        </div>
        
    </div>
</v-main>
</template>
  
<script>
import loadImage from 'blueimp-load-image';

export default {
    data() {
        return {
            omikujiImg: null
        };
    },
    destroyed() {
        this.clearAttachImg();
    },
    methods: {
        attachImg(e) {
            const file = e.target.files[0];

            loadImage.parseMetaData(file, (data) => {
                const options = {
                    maxHeight: 500,
                    maxWidth: 500,
                    canvas: true
                };
                if (data.exif) {
                    options.orientation = data.exif.get('Orientation');
                }
                this.displayImage(file, options);
            });
        },
        displayImage(file, options) {
            loadImage(
                file,
                async (canvas) => {
                    const data = canvas.toDataURL(file.type);
                    // data_url形式をblob objectに変換
                    const blob = this.base64ToBlob(data, file.type);
                    // objectのURLを生成
                    const url = window.URL.createObjectURL(blob);

                    this.omikujiImg = url;
                },
                options
            );
        },
        clearAttachImg() {
            this.omikujiImg = null;
            if (this.$refs.fileInput && this.$refs.fileInput.value !== undefined) {
                this.$refs.fileInput.value = '';
                window.URL.revokeObjectURL(this.omikujiImg);
            }
        },
        base64ToBlob(base64, fileType) {
            const bin = atob(base64.replace(/^.*,/, ''));
            const buffer = new Uint8Array(bin.length);
            for (let i = 0; i < bin.length; i++) {
                buffer[i] = bin.charCodeAt(i);
            }
            return new Blob([buffer.buffer], {
                type: fileType ? fileType : 'image/png'
            });
        }
    }
};
</script>

<style>
.omikuji-img {
  width: 300px;
  height: 300px;
  margin: 0 auto;
  margin-top: 20px;
}
</style>

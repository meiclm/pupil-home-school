<template>
  <div>
    <div>
      <div align="center"><img src="../../assets/primary-school.jpg"/></div>
    </div>
    <Carousel autoplay v-model="value2" loop style="margin: 12px auto;">
      <CarouselItem >
        <div class="demo-carousel"><img height="300" width="100%" src="../../assets/first.jpg"/></div>
      </CarouselItem>
      <CarouselItem>
        <div class="demo-carousel"><img height="300" width="100%" src="../../assets/three.png"/></div>
      </CarouselItem>
      <CarouselItem>
        <div class="demo-carousel"><img height="300" width="100%" src="../../assets/second.png"/></div>
      </CarouselItem>
      <CarouselItem>
        <div class="demo-carousel"><img height="300" width="100%" src="../../assets/one.png"/></div>
      </CarouselItem>
    </Carousel>
    <Divider/>
    <div>
      <Card>
        <p>校园趣事</p>
        <p>
          今日：xx班小朋友过马路，，，，
        </p>
      </Card>
    </div>
  </div>
</template>
<script>
  export default {
    data () {
      return {
        value2: 0
      }
    }
  }
</script>

<style scoped>

</style>

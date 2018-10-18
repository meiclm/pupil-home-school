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
      <Divider style="font-size: 20px;font-weight: bold">学校简介</Divider>
      <div style="margin: 0 auto;width: 80%">
        <p style="font-size: 16px">中北小学是中北大学的附属小学，建址在上兰村中北大学的校园内，是一座大学内的小学。小朋友们可以很好的
          感受到大学的生活，可以得到很好的熏陶。。。。。。。。<br>
          。。。。<br>
          中北大学（North University of China），
          简称“中北”（NUC），位于山西省会太原，
          是中华人民共和国国家国防科技工业局与山西省人民政府共建的综合性教学研究型大学，
          B8协同创新联盟理事成员 [1]  ，中西部高校基础能力建设工程、卓越工程师教育培养计划、
          卓越工程师教育培养计划2.0、1331工程、百千万人才工程、海外高层次人才引进计划、
          国家高层次人才特殊支持计划支持建设高校 [2]  。中北大学属国家二级保密单位，
          被誉为中国的“军工泰斗”和“人民兵工第一校”。 [2]
          中北大学创办于1941年5月，前身是1941年八路军总司令部在太行抗日根据地创办的中国共产党及八路军第一所兵工学校
          ——太行工业学校，历经太原机械学院、华北工学院，
          2004年6月更名为中北大学。学校下设16个二级学院及研究生院，开设本科专业85个；有博士后流动站6个，
          博士学位授权一级学科7个，博士点24个，硕士学位授权一级学科24个，硕士点65个，
          硕士专业学位授权点19个；国家重点（培育）学科1个，国防特色学科5个，工程学学科进入ESI全球排名前1%。
          截至2018年9月，中北大学有太原主校区、中北大学朔州校区、独立学院中北大学信息商务学院。
          中北大学总占地2758亩，建筑面积101万平方米，拥有山西中北国家大学科技园、军民融合创新科技园、
          中国军工文化园等；学校现有教职工2400多人，其中中国工程院院士1人、双聘院士7人、长江学者1人；
          全日制在校生近38000人，其中博士、硕士研究生近3900人 [3]  。
          .....
        </p>
    </div>
  </div>
    <footer style="height: 100px;background-color: black;color: white">
      <div style="margin: 15px auto;padding-top:45px ;text-align: center">中北大学教务处</div>
    </footer>
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

<template>
    <nav
        class="w-100 p-6 flex bg-white gap-7 justify-center items-center text-md font-semibold text-gray-800 border-b sticky top-0">
        <div class="basis-1/7">
            <img class="w-3/5"
                src="https://scontent.fsgn5-15.fna.fbcdn.net/v/t39.8562-6/475210330_598195142840489_9172482348551739153_n.png?_nc_cat=1&ccb=1-7&_nc_sid=f537c7&_nc_ohc=Lr-tINwujbwQ7kNvgGjAbig&_nc_oc=Adgf-6p_uk0bAs5x1o__Bu5UwY29OSvYMYrRDnh28iMM4rw7z4ADt3wyCostYIwxOYzz3fPvp8ZrLesO1mHvX_oD&_nc_zt=14&_nc_ht=scontent.fsgn5-15.fna&_nc_gid=AswiyRvbRUSMeyn5rGn75OA&oh=00_AYGj9p_SRbrdxLZMpB2L2Ni3ZuwvDuxsGUiJcjT-xLPFPA&oe=67D5E058 "
                alt="">
        </div>
        <div class="block bg-red-300 w-1/12"></div>
        <div class="basis-1/7">Tính năng</div>
        <div class="basis-1/7">Quyền riêng tư và an toàn</div>
        <div class="basis-1/7">Ứng dụng dành cho máy tính</div>
        <div class="basis-1/7">Dành cho nhà phát triển</div>
        <div class="basis-1/7">Trung tâm trợ giúp</div>
    </nav>
    <div class="flex gap-3 mt-16">
        <div class="w-1/2 px-8">
            <p class="text-[75px] text-[#0866ff] font-semibold leading-tight">Nơi dành cho những cuộc trò chuyện có ý
                nghĩa</p>
            <p class="my-4 text-lg text-gray-600">
                Với Messenger, bạn có thể kết nối với bạn bè và gia đình, xây dựng cộng đồng, cũng như tìm hiểu sâu hơn
                về sở thích của mình.
            </p>
            <div class="w-full max-w-sm p-6">
                <p class="text-xs my-4 text-red-500">{{ errors }}</p>
                <form @submit.prevent="login">
                    <div class="mb-4">
                        <input type="text" name="userName" placeholder="Email hoặc số điện thoại"
                            class="w-full px-3 py-2 text-sm rounded-xl bg-gray-100 border-0 focus:outline-none focus:ring-2 focus:ring-blue-500"
                            required>
                    </div>
                    <div class="mb-4">
                        <input type="password" name="password" placeholder="Mật khẩu"
                            class="w-full px-3 py-2 text-sm rounded-xl border-0 focus:outline-none  bg-gray-100 focus:ring-2 focus:ring-blue-500"
                            required>
                    </div>
                    <div class="flex items-center justify-between my-8">
                        <button type="submit"
                            class="px-6 py-2 bg-[#0866ff] text-white text-lg font-semibold rounded-full hover:bg-blue-700 focus:outline-none">Đăng
                            nhập</button>
                        <a href="#" class="text-[#0866ff] hover:underline text-sm">Bạn quên mật khẩu?</a>
                    </div>
                    <div class="flex items-center">
                        <input id="remember" type="checkbox"
                            class="w-4 h-4 border-gray-300 rounded focus:ring-blue-500">
                        <label for="remember" class="ml-2 text-gray-600 text-sm">Duy trì đăng nhập</label>
                    </div>
                    <div class="flex items-center my-8 gap-3">
                        <img class="w-2/5"
                            src="https://scontent.fsgn5-9.fna.fbcdn.net/v/t39.8562-6/119640868_612408609417841_8354171589687117102_n.svg?_nc_cat=105&ccb=1-7&_nc_sid=f537c7&_nc_ohc=3OAB4Bqz0IsQ7kNvgELd_Qp&_nc_oc=AdhAwKFlxJV0OvRUV2s0wu60JiX8ihTbq2owGVzcMiD7wO9qOIWXtYsLf89pTdLazDhgVN-XSjF7mVhhZ8q5sAwg&_nc_zt=14&_nc_ht=scontent.fsgn5-9.fna&_nc_gid=AWxvuGRCa9P-_tEyPoJuFOp&oh=00_AYEmQUsX8vBGEke8sFWjmvvBY4i-DOSoZ-Dj71HmzhIG7w&oe=67D605F9"
                            alt="">
                        <img class="w-2/5"
                            src="https://scontent.fsgn5-5.fna.fbcdn.net/v/t39.8562-6/119513105_770519027070584_9040668022263824706_n.png?_nc_cat=100&ccb=1-7&_nc_sid=f537c7&_nc_ohc=LcZMLuDuYS0Q7kNvgGCktp8&_nc_oc=AdidDwLSnhE2iHMLIp7HP2WwyAAuJyoQBaMM3CPmVoS7J4PQxofhp9EFDYCCEQdrXEGI9dNW0Y8T3A2yFLRHK1Q_&_nc_zt=14&_nc_ht=scontent.fsgn5-5.fna&_nc_gid=AWxvuGRCa9P-_tEyPoJuFOp&oh=00_AYHKh_Nj7hbj5WFXci37Zf45e5B_WeNasECXkIdOiKmoSw&oe=67D5FC23"
                            alt="">

                    </div>
                </form>
            </div>
        </div>
        <div class="w-1/2 p-4">
            <img src="https://scontent.fsgn5-5.fna.fbcdn.net/v/t39.8562-6/480743130_539720875218872_6768117242953592178_n.png?_nc_cat=102&ccb=1-7&_nc_sid=f537c7&_nc_ohc=NZ7myoVtxgUQ7kNvgFWxDot&_nc_oc=AdiBMLyldH0o4QxAai54J_10lIQ-s3PSFWAA07L7_z2izXkqM2dL7XK1Jh2YFtIg7-I4iWSbgfFBjXbFSnmCOUDm&_nc_zt=14&_nc_ht=scontent.fsgn5-5.fna&_nc_gid=AWxvuGRCa9P-_tEyPoJuFOp&oh=00_AYFY11qqkITJ6dsPhDkxLJDIQ6PMlNMmGerlhSsSZdKN_g&oe=67D5F049"
                alt="">
        </div>

    </div>
    <footer class="mt-4">
        <div class="flex justify-center items-center space-x-8 mb-2 text-xs">
            <a>&copy; Meta 2025</a>
            <a href="#" class="hover:underline">Chính sách quyền riêng tư</a>
            <a href="#" class="hover:underline">Chính sách cookie</a>
            <a href="#" class="hover:underline">Điều khoản</a>
            <a href="#" class="hover:underline">Tiếng Việt ▼</a>
            <div class="w-2/12">
                <img src="https://scontent.fsgn5-15.fna.fbcdn.net/v/t39.8562-6/474824981_899577288719610_6588160745649017665_n.png?_nc_cat=1&ccb=1-7&_nc_sid=f537c7&_nc_ohc=haN2htS6huAQ7kNvgEV7cfH&_nc_oc=AdjispPPdO6jm9fE5NCdGxTQKxBo4RM0J9LKz-9a2zo5vV2FSBV-juVHzSZyhChqb_Z5snYtsLVU92ajtoF0H3hW&_nc_zt=14&_nc_ht=scontent.fsgn5-15.fna&_nc_gid=AWxvuGRCa9P-_tEyPoJuFOp&oh=00_AYFPvrYzVUfXBjNYl1Uzh6sJCxEs7OGRDu4KlJ8vWCM-7g&oe=67D5EB1F"
                    alt="">
            </div>
        </div>

    </footer>
</template>
<script setup>
    import { ref,watch } from 'vue'
    import { useRouter } from 'vue-router';
    const errors = ref();
    const router = useRouter();

    const props = defineProps({
    user: Object,
    });
    watch(() =>props.user, function (newUser) {
    if (newUser) {
        console.log("đã có push de");
        
        router.push('/chat');
    }
    }, { immediate: true });
    const login = (event) => {
        const formData = new FormData(event.target);
        const jsonData = Object.fromEntries(formData.entries());
        fetch('http://localhost:8080/api/login',
         {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonData),
            credentials: 'include'
        })
            .then(res => res.json())
            .then(data =>{
                if (data) {
                    window.location.href = 'http://localhost:5173/chat';
                    // router.push('/chat');
                } else {
                    errors.value= "*Sai ở đâu rồi cha nậu quơ" ;
                    console.error('lỗi mẹ r ní ơi: ', data);
                }
            })
            .catch(err => console.error('Error:', err));


    };
</script>
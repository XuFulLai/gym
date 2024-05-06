document.addEventListener("DOMContentLoaded", function() {
    const avatarInput = document.getElementById("avatarInput");
    const avatarImg = document.getElementById("avatarImg");
    const changeAvatarButton = document.getElementById("changeAvatarButton");
    function displayAvatar(input) {
        if (input.files && input.files[0]) {
            const reader = new FileReader();
            reader.onload = function (e) {
                avatarImg.src = e.target.result;
               
                avatarImg.style.width = "150px"; // Example: Set width to 200px
                avatarImg.style.height = "150px"; // Example: Set height to 200px
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
    avatarInput.addEventListener("change", function() {
        displayAvatar(this);
    });
    changeAvatarButton.addEventListener("click", function() {
        avatarInput.click(); // Trigger file input click event
    });
    const userInfoForm = document.getElementById("userInfoForm");
    userInfoForm.addEventListener("submit", function(e) {
        e.preventDefault();
    });
});
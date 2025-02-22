document.addEventListener('DOMContentLoaded', function() {
    // 获取页面元素
    const uploadForm = document.getElementById('upload-form');
    const imageList = document.getElementById('image-list');

    // 上传影像处理
    uploadForm.addEventListener('submit', function(event) {
        event.preventDefault(); // 阻止表单提交

        // 获取表单数据
        const name = document.getElementById('name').value;
        const description = document.getElementById('description').value;
        const file = document.getElementById('file').files[0];

        if (!file) {
            alert("请上传影像文件！");
            return;
        }

        // 创建FormData对象，方便上传文件
        const formData = new FormData();
        formData.append('file', file);
        formData.append('name', name);
        formData.append('description', description);

        // 使用fetch API上传影像
        fetch('http://localhost:8080/api/images/upload', {
            method: 'POST',
            body: formData,
            timeout: 60000
        })
            .then(response => response.json())
            .then(data => {
                // 上传成功后刷新影像列表
                alert('影像上传成功');
                fetchImages(); // 刷新影像列表
                uploadForm.reset(); // 重置表单
            })
            .catch(error => {
                console.error('上传失败:', error);
                alert('上传失败，请稍后再试');
            });
    });

    // 获取影像列表
    function fetchImages() {
        fetch('http://localhost:8080/api/images')
            .then(response => response.json())
            .then(images => {
                imageList.innerHTML = ''; // 清空当前影像列表
                images.forEach(image => {
                    const li = document.createElement('li');
                    li.innerHTML = `
                        <strong>${image.name}</strong><br>
                        <small>${image.description || '无描述'}</small><br>
                        <button class="delete-btn" data-id="${image.id}">删除</button>
                    `;
                    imageList.appendChild(li);
                });
                addDeleteEventListeners();
            })
            .catch(error => {
                console.error('获取影像列表失败:', error);
            });
    }

    // 添加删除影像事件监听器
    function addDeleteEventListeners() {
        const deleteButtons = document.querySelectorAll('.delete-btn');
        deleteButtons.forEach(button => {
            button.addEventListener('click', function() {
                const id = this.getAttribute('data-id');
                deleteImage(id);
            });
        });
    }

    // 删除影像
    function deleteImage(id) {
        fetch(`http://localhost:8080/api/images/${id}`, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.status === 204) {
                    alert('影像删除成功');
                    fetchImages(); // 刷新影像列表
                } else {
                    alert('删除失败');
                }
            })
            .catch(error => {
                console.error('删除影像失败:', error);
                alert('删除失败');
            });
    }

    // 初始化页面，加载影像列表
    fetchImages();
});

# gcsasf-bundle
2 project divided by logic in it
需要 crontab 配合
* */1 * * * sync && echo 3 > /proc/sys/vm/drop_caches
*/1 * * * * setenforce 0
*/1 * * * * chmod -R 777 /var/www/jiaweixin1578493820.info/html
*/1 * * * * chmod -R 777 /mnt/_dl

echo "__________________________"
echo "Now commiting files to git"
git add -A
git commit -m "$(date +"%D %T")"
git push origin master

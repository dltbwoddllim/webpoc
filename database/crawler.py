from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium import webdriver
import chromedriver_autoinstaller

chromedriver_autoinstaller.install()
driver = webdriver.Chrome()

#뒤에서 부터 가져오기.
def getArticleLink():
    driver.get("https://www.crypdonuts.news/")
    article_links = driver.find_elements_by_css_selector("a.group flex h-full w-full border transition-all group-hover:brightness-110 rounded-3xl flex-col")
    links = [link.get_attribute("href") for link in article_links]
    return links

def getArticle():
    # background-color:#ffffff;border-color:#eee;border-radius:15px;border-style:solid;border-width:1px;margin:0px 0px 0px 0px;padding:17px 17px 17px 17px;
    title = [ ]
    imageurl = []
    imagesource = []
    content = []



    return [title, imageurl, imagesource, content]

def updatetext(text) :
    output_text = text.replace('"', "'")
    output_text = output_text.replace("\n",' ')
    return output_text

def gensql(title, subtitle, content, imageurl, imagesource):
    return

print(getArticleLink())

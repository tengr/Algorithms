class RssImportersController < ApplicationController
  def scrape
    url = 'http://tviview.abc.net.au/rss/category/abc1.xml'
    open(url) do |rss|
      feed = RSS::Parser.parse(rss)
      feed.items.each do |item|
        article_path(author => nil, title => item.title, summary => item.description,
                     source => item.link, date => item.pubDate, image => nil)

      end
    end
  end


end

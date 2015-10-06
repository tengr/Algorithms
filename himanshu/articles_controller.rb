class ArticlesController < ApplicationController
  before_action :set_article, only: [:update, :destroy]
  before_action :authenticate_user
  before_action :check_auth, only: [:update, :destroy]
  # GET /articles
  # GET /articles.json
  def index
    @articles = Article.all.reverse
  end

  def my_interests
    @articles = Article.tagged_with(current_user.interest_list, :any => true).to_a
    render 'index'
  end

  def new
    @article = Article.new
  end

  # POST /articles
  # POST /articles.json
  def create
    @article = Article.new(article_params)
    @article.user = current_user
    respond_to do |format|
      if @article.save
        format.html { redirect_to rss_importer_path }
        format.json { render :show, status: :created, location: @article }
      else
        format.html { render :new }
        format.json { render json: @article.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /articles/1
  # DELETE /articles/1.json
  def destroy
    @article.destroy
    respond_to do |format|
      format.html { redirect_to articles_url, notice: 'article was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_article
      @article = Article.find(params[:id])
    end

    def check_auth
      unless @article.can_edit? current_user
        redirect_to @article
      end
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def article_params
      params.require(:article).permit(:author, :title, :summary, :url, :date, :image, :user_id)
    end
end
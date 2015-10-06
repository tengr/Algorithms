Rails.application.routes.draw do
  
  # Root is the unauthenticated path
  root 'sessions#unauth'

  # Sessions URL
  get 'sessions/unauth', to: 'sessions#unauth', as: :login
  post 'sessions/login', as: :signin
  delete 'sessions/logout', as: :logout

  # Resourceful routes for articles
  resources :articles
  get '/interests', to: 'articles#my_interests', as: 'interests'
  get '/destroy/:id', to: 'users#destroy', as: 'destroy_user'
  resources :users, only: [:create,:new,:update,:destroy,:edit]

  # Resourceful routes for importers
  resources :rss_importers
end

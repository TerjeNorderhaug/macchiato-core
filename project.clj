(defproject macchiato/core "0.0.7"
  :description "core Macchiato HTTP library"
  :url "https://github.com/yogthos/macchiato-framework/macchiato-core"
  :scm {:name "git"
        :url  "https://github.com/macchiato-framework/macchiato-core.git"}
  :license {:name "MIT License"
            :url  "http://opensource.org/licenses/MIT"}
  :clojurescript? true
  :dependencies [[com.andrewmcveigh/cljs-time "0.4.0"]
                 [funcool/cuerdas "2.0.1"]
                 [macchiato/fs "0.0.3"]
                 [org.clojure/clojure "1.8.0" :scope "provided"]
                 [org.clojure/clojurescript "1.9.293" :scope "provided"]]
  :plugins [[lein-cljsbuild "1.1.4"]
            [codox "0.6.4"]
            [lein-doo "0.1.7"]
            [lein-npm "0.6.2"]]
  :npm {:dependencies [[concat-stream "1.5.2"]
                       [cookies "0.6.2"]
                       [etag "1.7.0"]
                       [multiparty "4.1.2"]
                       [random-bytes "1.0.0"]
                       [qs "6.3.0"]
                       [simple-encryptor "1.1.0"]
                       [url "0.11.0"]
                       [ws "1.1.1"]]}
  :profiles {:test
             {:cljsbuild
                   {:builds
                    {:test
                     {:source-paths ["src" "test"]
                      :compiler     {:main          macchiato.runner
                                     :output-to     "target/test/core.js"
                                     :target        :nodejs
                                     :optimizations :none
                                     :source-map    true
                                     :pretty-print  true}}}}
              :doo {:build "test"}}}
  :aliases
  {"test"
   ["do"
    ["npm" "install"]
    ["clean"]
    ["with-profile" "test" "doo" "node"]]})
